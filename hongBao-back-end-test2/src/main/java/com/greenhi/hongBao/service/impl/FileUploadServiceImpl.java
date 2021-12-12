package com.greenhi.hongBao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.greenhi.hongBao.controller.FileUploadController;
import com.greenhi.hongBao.entity.FileInfo;
import com.greenhi.hongBao.mapper.FileInfoMapper;
import com.greenhi.hongBao.service.FileUploadService;
import com.greenhi.hongBao.unit.Result;
import com.greenhi.hongBao.unit.ResultEnum;
import com.greenhi.hongBao.unit.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service("FileUploadService")
public class FileUploadServiceImpl extends ServiceImpl<FileInfoMapper,FileInfo> implements FileUploadService {

    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @Value("${uploadDir_file}")
    private String uploadDir_file;

    @Override
    public Result upload(MultipartFile file, FileInfo fileInfo) {
        if (file.isEmpty()) {
            return ResultUtil.error(ResultEnum.FILE_NOT_EXISTS.getCode(), "文件不能为空");
        }
        // 获取文件名
        String fileName = fileInfo.getName();
        //logger.info("上传的文件名为：" + fileName);
        // 上传时的文件名
        String originalFilename = file.getOriginalFilename();
        // 获取文件的后缀名
        String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
        //logger.info("上传的后缀名为：" + suffixName);
        // 解决中文问题，linux下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;
        File dest = new File(uploadDir_file + fileName + suffixName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            logger.info("~~~~~~~~~该目录不存在，新建~~~~~");
            dest.getParentFile().mkdirs();
        }
        logger.info("Absolute directory: "+dest.getParentFile().getAbsoluteFile());
        try {
            /**
             * 图片访问路径写入数据库
             */
            if (getOne(new QueryWrapper<FileInfo>()
                    .eq("name", fileInfo.getName()))
                    == null) {
                fileInfo.setName(fileName + suffixName);
                fileInfo.setLocation(dest.toString());
                save(fileInfo);
                //上传文件到dest
                file.transferTo(dest.getAbsoluteFile());
                logger.info("上传成功后的文件路径为：" + dest);
                return ResultUtil.success("文件上传成功");
            }
            return ResultUtil.error(ResultEnum.FILE_IS_EXISTS.getCode(), ResultEnum.FILE_IS_EXISTS.getMsg());
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultUtil.error(ResultEnum.FILE_NOT_UPLOADS.getCode(), ResultEnum.FILE_NOT_UPLOADS.getMsg());
    }

}
