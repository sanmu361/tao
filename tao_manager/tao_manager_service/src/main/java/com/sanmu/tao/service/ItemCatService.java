package com.sanmu.tao.service;

import com.sanmu.tao.pojo.TbItem;
import com.sanmu.tao.pojo.TbItemCat;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-04 19:36
 **/
public interface ItemCatService {

    public List<TbItemCat> getItemCatList(Long parentId);
}
