package com.SoulMen.business.createManager.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface createService {
    void createTable(MultipartFile MultipartFile) throws IOException;

    void insertTable(MultipartFile MultipartFile) throws IOException;
}
