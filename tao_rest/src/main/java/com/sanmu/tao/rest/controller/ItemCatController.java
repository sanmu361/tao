package com.sanmu.tao.rest.controller;

import com.sanmu.tao.rest.pojo.ItemCatResult;
import com.sanmu.tao.rest.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-27 15:46
 **/
@Controller
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/itemcat/list")
    @ResponseBody
    public Object getItemCatList(String callback){
        ItemCatResult result = itemCatService.getItemCatList();

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);

        mappingJacksonValue.setJsonpFunction(callback);

        return mappingJacksonValue;

    }
}
