package com.sanmu.tao.portal.controller;

import com.sanmu.tao.portal.service.AdService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-13 16:39
 **/
@Controller
public class IndexController {

    @Resource
    AdService adService;

    @RequestMapping("/index")
    public String showIndex(Model model) throws Exception {
        String adResult = adService.getContentList();
        model.addAttribute("ad1",adResult);
        return "index";
    }
}
