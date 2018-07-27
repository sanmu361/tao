package com.sanmu.tao.rest.service.impl;

import com.sanmu.tao.mapper.TbContentMapper;
import com.sanmu.tao.pojo.TaotaoResult;
import com.sanmu.tao.pojo.TbContent;
import com.sanmu.tao.pojo.TbContentExample;
import com.sanmu.tao.rest.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-27 19:31
 **/
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private TbContentMapper contentMapper;

    @Override
    public TaotaoResult getContentList(long cid) {
        TbContentExample example = new TbContentExample();
        //添加条件
        TbContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(cid);
        List<TbContent> list = contentMapper.selectByExample(example);
        return TaotaoResult.ok(list);

    }
}
