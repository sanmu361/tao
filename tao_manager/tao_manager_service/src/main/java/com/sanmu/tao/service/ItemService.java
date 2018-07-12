package com.sanmu.tao.service;

import com.sanmu.tao.pojo.EUDataGridResult;
import com.sanmu.tao.pojo.TaotaoResult;
import com.sanmu.tao.pojo.TbItem;
import com.sanmu.tao.pojo.TbItemExample;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-04 17:24
 **/
public interface ItemService {

    public EUDataGridResult getItemList(int page,int rows);

    TaotaoResult createItem(TbItem item, String desc, String itemParams) throws Exception;

    TaotaoResult updateItem(TbItem item, String desc, String itemParams) throws Exception;

    TaotaoResult getItemDesc(Long itemId);

    TaotaoResult getItemParam(Long itemId);
}
