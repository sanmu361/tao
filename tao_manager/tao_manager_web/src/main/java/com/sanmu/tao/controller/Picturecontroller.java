package com.sanmu.tao.controller;

import com.sanmu.tao.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-12 16:17
 **/
@Controller
@RequestMapping("/pic")
public class Picturecontroller {

    @Autowired
    private PictureService pictureService;

    @RequestMapping("/upload")
    @ResponseBody
    public Map upload(@RequestParam("uploadFile") MultipartFile uploadFile){
        Map result = pictureService.uploadPicture(uploadFile);
        return result;
    }
}
