package com.sanmu.tao.service;

import com.sanmu.tao.pojo.EUTreeNode;
import com.sanmu.tao.pojo.TaotaoResult;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-27 17:59
 **/
public interface ContentCategoryService {

    List<EUTreeNode> getCategoryList(long parentId);
    TaotaoResult insertContentCategory(long parentId,String name);

}
