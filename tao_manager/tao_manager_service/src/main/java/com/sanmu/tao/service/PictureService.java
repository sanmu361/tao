package com.sanmu.tao.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-12 12:32
 **/
public interface PictureService {

    public Map uploadPicture(MultipartFile uploadFi);
}
