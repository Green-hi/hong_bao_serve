package com.greenhi.hongBao.controller;

import com.greenhi.hongBao.entity.FileInfo;
import com.greenhi.hongBao.service.FileUploadService;
import com.greenhi.hongBao.unit.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "文件操作")
@RequestMapping(value = "/upload")
@RestController
public class FileUploadController {

    @Autowired
    FileUploadService service;

    @ApiOperation("文件上传")
    @RequestMapping(value = "/file", method = RequestMethod.POST)
    public Result uploadFile(
            @RequestParam(value = "file") MultipartFile file,
            FileInfo fileInfo) {
        return service.upload(file, fileInfo);
    }
}
