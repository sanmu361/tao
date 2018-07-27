package com.sanmu.tao.rest.service.impl;

import com.sanmu.tao.mapper.TbItemCatMapper;
import com.sanmu.tao.mapper.TbItemParamMapper;
import com.sanmu.tao.pojo.TbItemCat;
import com.sanmu.tao.pojo.TbItemCatExample;
import com.sanmu.tao.rest.pojo.ItemCat;
import com.sanmu.tao.rest.pojo.ItemCatResult;
import com.sanmu.tao.rest.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-27 15:37
 **/
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Override
    public List<?> getItemCatList(long parentid) {
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        //查询parentid为0的分类信息
        criteria.andParentIdEqualTo(parentid);
        List<TbItemCat> list = itemCatMapper.selectByExample(example);
        List dataList = new ArrayList();
        for (TbItemCat tbItemCat : list) {
            //判断是否为父节点
            if (tbItemCat.getIsParent()) {
                ItemCat itemCat = new ItemCat();
                itemCat.setUrl("/category/" + tbItemCat.getId() + ".html");
                itemCat.setName(tbItemCat.getName());
                //递归调用
                itemCat.setItem(getItemCatList(tbItemCat.getId()));
                //添加到列表
                dataList.add(itemCat);
            } else {
                String catItem = "/item/" + tbItemCat.getId() + ".html|" + tbItemCat.getName();
                dataList.add(catItem);
            }
        }
        return dataList;

    }

    @Override
    public ItemCatResult getItemCatList() {
        ItemCatResult catResult = new ItemCatResult();
        //查询分类列表
        catResult.setData(getItemCatList(0));
        return catResult;
    }
}
