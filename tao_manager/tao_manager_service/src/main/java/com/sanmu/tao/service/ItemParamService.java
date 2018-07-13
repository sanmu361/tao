package com.sanmu.tao.service;

import com.sanmu.tao.pojo.EUDataGridResult;
import com.sanmu.tao.pojo.TaotaoResult;
import com.sanmu.tao.pojo.TbItemParam;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-13 10:51
 **/
public interface ItemParamService {
    EUDataGridResult getItemParamList(Integer page, Integer rows);

    TaotaoResult getItemParamByCid(Long itemCatId);

    TaotaoResult insertItemParam(TbItemParam itemParam);
}
