package com.sanmu.tao.service.impl;

import com.sanmu.tao.IDUtils.FtpUtil;
import com.sanmu.tao.IDUtils.IDUtils;
import com.sanmu.tao.service.PictureService;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-12 12:33
 **/
@Service
public class PictureServiceImpl implements PictureService{

    private static final Logger logger = LoggerFactory.getLogger(PictureServiceImpl.class);

    @Value("${FTP_ADDRESS}")
    private String FTP_ADDRESS;

    @Value("${FTP_PORT}")
    private Integer FTP_PORT;

    @Value("${FTP_USERNAME}")
    private String FTP_USERNAME;

    @Value("${FTP_PASSWORD}")
    private String FRT_PASSWORD;

    @Value("${FTP_BASE_PATH}")
    private String FTP_BASE_PATH;

    @Value("${IMAGE_BASE_URL}")
    private String IMAGE_BASE_URL;


    @Override
    public Map uploadPicture(MultipartFile uploadFile) {
        Map resultMap = new HashMap();

        try {
            String oldName = uploadFile.getOriginalFilename();

            String newName = IDUtils.getFileNmae();
            newName = newName + oldName.substring(oldName.lastIndexOf("."));

            String imagePath = new DateTime().toString("/yyyy/MM/dd");
            boolean result = FtpUtil.uploadFile(FTP_ADDRESS,FTP_PORT,FTP_USERNAME,FRT_PASSWORD,FTP_BASE_PATH,imagePath,newName,uploadFile.getInputStream());

            if(!result){
                resultMap.put("error",1);
                resultMap.put("message","文件上传失败");
                return resultMap;
            }
            resultMap.put("error",0);
            resultMap.put("url",IMAGE_BASE_URL + imagePath + "/" + newName);
            return resultMap;
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("文件上传失败！！！",e);
            resultMap.put("error", 1);
            resultMap.put("message", "文件上传发生异常");
            return resultMap;
        }
    }
}
