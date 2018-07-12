package com.sanmu.tao.controller;

import com.sanmu.tao.pojo.EUDataGridResult;
import com.sanmu.tao.pojo.TaotaoResult;
import com.sanmu.tao.pojo.TbItem;
import com.sanmu.tao.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-04 17:02
 **/
@Controller
@RequestMapping("/item")
public class ItemController {

    @Resource
    ItemService itemService;

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getItemList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "30") Integer rows) {
        try{
            EUDataGridResult result = itemService.getItemList(page, rows);
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value="/save",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult createItem(TbItem item,String desc,String itemParams) throws Exception {
        TaotaoResult result = itemService.createItem(item,desc,itemParams);
        return result;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult updateItem(TbItem item,String desc,String itemParams) throws Exception {
        TaotaoResult result = itemService.updateItem(item,desc,itemParams);
        return result;
    }

    @RequestMapping(value = "/desc/{itemId}")
    @ResponseBody
    public TaotaoResult getItemDesc(@PathVariable Long itemId) throws Exception {
        TaotaoResult result = itemService.getItemDesc(itemId);
        return result;
    }

    @RequestMapping(value = "/param/{itemId}")
    @ResponseBody
    public TaotaoResult getItemParam(@PathVariable Long itemId) throws Exception {
        TaotaoResult result = itemService.getItemParam(itemId);
        return result;
    }

}
