package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
    //文件下载
    String upload(MultipartFile file, String path);
}
