package com.example.controller;

import com.example.commonresponse.CommonResponse;
import com.example.commonresponse.FileResponse;
import com.example.model.TestDocsModel;
import com.example.service.ServiceI;
import com.example.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Provider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/file")
public class FileController {

    private StorageService storageService;

    @Autowired
    private ServiceI<TestDocsModel> testDocsServiceI;

    @Autowired
    private Provider<CommonResponse> commonResponseProvider;

    public FileController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/model/{patientId}/{testId}")
    public String listAllFiles(Model model,@PathVariable("patientId") String patientId,@PathVariable("testId") String testId) {

        model.addAttribute("files", storageService.loadAll(patientId+"/"+testId).map(
                path -> ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/download/")
                        .path(path.getFileName().toString())
                        .toUriString())
                .collect(Collectors.toList()));
        return "listFiles";
    }

    @GetMapping("/{patientId}/{testId}")
    public ResponseEntity<Object> listAllFiles(@PathVariable("patientId") String patientId,@PathVariable("testId") String testId) {

        List<String> fileRspLst=new ArrayList<>();
        fileRspLst=storageService.loadAll(patientId+"/"+testId).map(
                path -> ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/download/")
                        .path(path.getFileName().toString())
                        .toUriString())
                .collect(Collectors.toList());
        System.out.println(fileRspLst);
        return commonResponseProvider.get().getSuccessFullResponse(fileRspLst,true);
    }

    @GetMapping("/download/{filename:.+}/{patientId}/{testId}")
    @ResponseBody
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename,@PathVariable("patientId") String patientId,@PathVariable("testId") String testId) {
        Resource resource = storageService.loadAsResource(filename,patientId+"/"+testId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @PostMapping("/upload-file/{patientId}/{testId}")
    @ResponseBody
    public FileResponse uploadFile(
            @ModelAttribute("testDocs") TestDocsModel testDocsModel,
            @PathVariable("patientId") String patientId,@PathVariable("testId") String testId
    ,int index) {

        index =testDocsModel.getFile().size() ==1 ? 0:index;

        String name = storageService.store(testDocsModel.getFile().get(index),patientId+"/"+testId);
        String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(name)
                .toUriString();
        testDocsModel.setTestDocName(name);

        TestDocsModel newTestDocsModel=null;
        if(testDocsModel.getTestDocsIds() != null && testDocsModel.getTestDocsIds().size() > 0 ){
            storageService.deleteFile(patientId+"/"+testId,testDocsModel.getDeleteFile().get(index));
            testDocsModel.setTestDocsId(testDocsModel.getTestDocsIds().get(index));
            newTestDocsModel=testDocsServiceI.update(testDocsModel);
        }else{
            newTestDocsModel=testDocsServiceI.add(testDocsModel);
        }

        return new FileResponse<>(name, uri, testDocsModel.getFile().get(0).getContentType(), testDocsModel.getFile().get(0).getSize(),newTestDocsModel);
    }

    @PostMapping("/upload-multiple-files/{patientId}/{id}")
    @ResponseBody
    public List<FileResponse> uploadMultipleFiles(
            @ModelAttribute("testDocs") TestDocsModel testDocsModels,
            @PathVariable("patientId") String patientId,@PathVariable("id") String testId
    ) {
        List<FileResponse> fileResponseList=new ArrayList<>();
        for(int i=0;i<testDocsModels.getFile().size();i++){
            FileResponse fileResponse=uploadFile(testDocsModels,patientId,testId,i);
            fileResponseList.add(fileResponse);
        }
        return fileResponseList;
    }
// update concept not for file
    /*
    * when file change that time first delete call fire then after upload file
    * and insert delete file record in testDocsLog and update docActive =false;
    * when recover call just update doActive=true;
    * */
    @PutMapping("/update-multiple-files/{patientId}/{id}")
    @ResponseBody
    public ResponseEntity<Object> updateMultipleFiles(
            @ModelAttribute("testDocs") TestDocsModel testDocsModel,
            @PathVariable("patientId") String patientId,@PathVariable("id") String testId
    ) {
        List<FileResponse> fileResponseList=new ArrayList<>();
        for(int i=0;i<testDocsModel.getFile().size();i++){
            FileResponse fileResponse=uploadFile(testDocsModel,patientId,testId,i);
            fileResponseList.add(fileResponse);
        }
        return listAllFiles(patientId,testId);
    }
}
