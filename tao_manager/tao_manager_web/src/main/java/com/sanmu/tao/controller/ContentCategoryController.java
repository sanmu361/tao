package com.sanmu.tao.controller;

import com.sanmu.tao.pojo.EUTreeNode;
import com.sanmu.tao.pojo.TaotaoResult;
import com.sanmu.tao.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-27 18:03
 **/
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {

    @Autowired
    private ContentCategoryService contentCategoryService;

    @RequestMapping("/list")
    @ResponseBody
    public List<EUTreeNode> getContentCatList(@RequestParam(value="id", defaultValue="0")Long parentId) {
        List<EUTreeNode> list = contentCategoryService.getCategoryList(parentId);
        return list;
    }

    @RequestMapping("/create")
    @ResponseBody
    public TaotaoResult createContentCategory(Long parentId, String name) {
        TaotaoResult result = contentCategoryService.insertContentCategory(parentId, name);
        return result;
    }

}
