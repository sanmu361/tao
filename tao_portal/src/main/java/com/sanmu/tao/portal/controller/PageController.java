package com.sanmu.tao.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-13 16:39
 **/
@Controller
public class PageController {

    @RequestMapping("/index")
    public String showIndex(){
        return "index";
    }
}
