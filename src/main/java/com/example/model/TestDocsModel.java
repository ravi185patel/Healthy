package com.example.model;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Component
public class TestDocsModel {

    private Long testDocsId;
    private Long testId;
    private String testDocName;
    private List<MultipartFile> file;
    private List<Long> testDocsIds;
    private List<String> deleteFile;

    public List<Long> getTestDocsIds() {
        return testDocsIds;
    }

    public void setTestDocsIds(List<Long> testDocsIds) {
        this.testDocsIds = testDocsIds;
    }

    public Long getTestDocsId() {
        return testDocsId;
    }

    public void setTestDocsId(Long testDocsId) {
        this.testDocsId = testDocsId;
    }

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    public String getTestDocName() {
        return testDocName;
    }

    public void setTestDocName(String testDocName) {
        this.testDocName = testDocName;
    }

    public List<MultipartFile> getFile() {
        return file;
    }

    public void setFile(List<MultipartFile> file) {
        this.file = file;
    }

    public List<String> getDeleteFile() {
        return deleteFile;
    }

    public void setDeleteFile(List<String> deleteFile) {
        this.deleteFile = deleteFile;
    }
}
