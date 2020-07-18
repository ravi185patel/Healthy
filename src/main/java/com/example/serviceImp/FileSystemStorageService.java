package com.example.serviceImp;
import com.example.service.StorageService;
import com.example.userdefineexception.FileNotFoundException;
import com.example.userdefineexception.PathDoesNotExistsException;
import com.example.userdefineexception.StorageException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

@Service
public class FileSystemStorageService implements StorageService {

    private Path rootLocation;

    @Override
//    @PostConstruct
    public void init() {
//        try {
//            Files.createDirectories(rootLocation);
//        } catch (IOException e) {
//            throw new StorageException("Could not initialize storage location", e);
//        }
    }

    @Override
    public String store(MultipartFile file,String path) {
        checkDir(path);
        this.rootLocation=Paths.get("./uploads/"+path+"/");
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        String newfileName="";
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + filename);
            }
            if (filename.contains("..")) {
                // This is a security check
                throw new StorageException(
                        "Cannot store file with relative path outside current directory "
                                + filename);
            }
            try (InputStream inputStream = file.getInputStream()) {
                newfileName=String.valueOf(System.currentTimeMillis());
                newfileName=path.replace("/","_")+"_"+newfileName+filename.substring(filename.indexOf("."),filename.length());
                Files.copy(inputStream, this.rootLocation.resolve(newfileName),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        }
        catch (IOException e) {
            throw new StorageException("Failed to store file " + filename, e);
        }
        return newfileName;
    }

    @Override
    public Stream<Path> loadAll(String path) {
        checkDir(path);
        this.rootLocation=Paths.get("./uploads/"+path+"/");
        try {
            return Files.walk(this.rootLocation, 1)
                    .filter(relPath -> !relPath.equals(this.rootLocation))
                    .map(this.rootLocation::relativize);
        }
        catch (IOException e) {
            throw new StorageException("Failed to read stored files", e);
        }

    }

    @Override
    public Path load(String filename,String path) {
        checkDir(path);
        this.rootLocation=Paths.get("./uploads/"+path+"/");
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename,String path) {
        checkDir(path);
        this.rootLocation=Paths.get("./uploads/"+path+"/");
        try {
            Path file = load(filename,path);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new FileNotFoundException(
                        "Could not read file: " + filename);
            }
        }
        catch (MalformedURLException e) {
            throw new FileNotFoundException("Could not read file: " + filename, e);
        }
    }

    @Override
    public void deleteAll(String path) {
        checkDir(path);
        this.rootLocation=Paths.get("./uploads/"+path+"/");
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    @Override
    public void deleteFile(String path,String filename) {
        checkDir(path);
        this.rootLocation=Paths.get("./uploads/"+path+"/");
        File file = new File("./uploads/"+path+"/"+filename);
        if(file.delete()){
            System.out.println(" file deleted successfully");
        }else{
            throw new FileNotFoundException("File Not Found");
        }
    }

    public void checkDir(String path){
        File file = new File("./uploads/"+path+"/");
        System.out.println(file.isDirectory());
        if(!file. isDirectory()) {
          throw new PathDoesNotExistsException("Documents for specific Patient not exists");
        }
    }
}