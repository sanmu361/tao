package com.sanmu.tao.IDUtils;

import org.joda.time.DateTime;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-12 15:50
 **/
public class FtpUtilTest {

//    @Test
//    public void uploadFile() throws IOException {
//
//                String FTP_ADDRESS="192.168.181.125";
//        int FTP_PORT=21;
//        String FTP_USERNAME="root";
//        String FTP_PASSWORD="123456";
//        String FTP_BASE_PATH="/images";
//
//        String IMAGE_BASE_URL="http://192.168.181.125:8080/images";
//
//        File uploadFile = new File("D:\\SC01C25.jpg");
//
//        //生成一个新的文件名
//        //取原始文件名
//        String oldName = "SC01C25.jpg";
//        //生成新文件名
//        //UUID.randomUUID();
//        String newName = IDUtils.getFileNmae();
//        newName = newName + oldName.substring(oldName.lastIndexOf("."));
//        //图片上传
//        String imagePath = new DateTime().toString("/yyyy/MM/dd");
//        FileInputStream inputStream = new FileInputStream(uploadFile);
//        boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD,
//                FTP_BASE_PATH, imagePath, newName,inputStream);
//
//        System.out.println(result);
//    }
}