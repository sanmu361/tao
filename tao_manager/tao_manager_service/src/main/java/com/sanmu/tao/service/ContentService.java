package com.sanmu.tao.service;

import com.sanmu.tao.pojo.EUDataGridResult;
import com.sanmu.tao.pojo.TaotaoResult;
import com.sanmu.tao.pojo.TbContent;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-27 18:23
 **/
public interface ContentService {

    EUDataGridResult getContentList(long catId,Integer page,Integer rows);

    TaotaoResult insertContent(TbContent content);

    TaotaoResult updateContent(TbContent content);

    int deleteContent(long id);

    TaotaoResult deleteContents(String ids);
}
