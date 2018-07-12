package com.sanmu.tao.service.impl;

import com.sanmu.tao.mapper.TbItemCatMapper;
import com.sanmu.tao.pojo.TbItemCat;
import com.sanmu.tao.pojo.TbItemCatExample;
import com.sanmu.tao.pojo.TbItemExample;
import com.sanmu.tao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-04 19:38
 **/
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<TbItemCat> getItemCatList(Long parentId) {
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();

        criteria.andParentIdEqualTo(parentId);

        List<TbItemCat> list = tbItemCatMapper.selectByExample(example);

        return list;
    }
}
