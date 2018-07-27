package com.sanmu.tao.rest.service;

import com.sanmu.tao.rest.pojo.ItemCatResult;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-27 15:36
 **/
public interface ItemCatService {

    List<?> getItemCatList(long parentid);

    ItemCatResult getItemCatList();
}
