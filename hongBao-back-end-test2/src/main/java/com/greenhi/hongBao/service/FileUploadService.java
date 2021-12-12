package com.greenhi.hongBao.service;

import com.greenhi.hongBao.entity.FileInfo;
import com.greenhi.hongBao.unit.Result;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

    Result upload(MultipartFile file, FileInfo fileInfo);

}
