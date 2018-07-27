package com.sanmu.tao.controller;

import com.sanmu.tao.pojo.EUDataGridResult;
import com.sanmu.tao.pojo.TaotaoResult;
import com.sanmu.tao.pojo.TbContent;
import com.sanmu.tao.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-27 18:22
 **/
@Controller
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping("/query/list")
    @ResponseBody
    public EUDataGridResult getContentList(Long categoryId,Integer page, Integer rows){
        EUDataGridResult result = contentService.getContentList(categoryId,page,rows);
        return  result;
    }


    @RequestMapping("/save")
    @ResponseBody
    public TaotaoResult addContent(TbContent content) {
        TaotaoResult result = contentService.insertContent(content);
        return result;
    }

    @RequestMapping("/edit")
    @ResponseBody
    public TaotaoResult editContent(TbContent content) {
        TaotaoResult result = contentService.updateContent(content);
        return result;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public TaotaoResult deleteContent(String ids) {
        TaotaoResult result = contentService.deleteContents(ids);
        return result;
    }

}
