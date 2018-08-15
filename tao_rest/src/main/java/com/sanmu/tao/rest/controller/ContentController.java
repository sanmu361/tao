package com.sanmu.tao.rest.controller;

import com.sanmu.tao.pojo.TaotaoResult;
import com.sanmu.tao.rest.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-27 19:32
 **/
@Controller
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping("/list/{cid}")
    @ResponseBody
    public TaotaoResult getContentList(@PathVariable Long cid){
        TaotaoResult result = null;
        try {
            result = contentService.getContentList(cid);
        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, e.getMessage());
        }
        return result;
    }

}
