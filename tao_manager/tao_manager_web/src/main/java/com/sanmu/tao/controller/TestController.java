package com.sanmu.tao.controller;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-08-03 16:32
 **/
@Controller
public class TestController {

    @RequestMapping("/api/put")
    @ResponseBody
    public Map upload(HttpServletRequest request){
        Map result = Maps.newHashMap();
        System.out.println(request);
        return result;
    }
}
