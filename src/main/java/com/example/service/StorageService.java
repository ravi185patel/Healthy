package com.example.service;


import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {

    void init();

    String store(MultipartFile file,String path);

    Stream<Path> loadAll(String path);

    Path load(String filename,String path);

    Resource loadAsResource(String filename,String path);

    void deleteAll(String path);

    void deleteFile(String path,String fileName);
}
