package com.sanmu.tao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sanmu.tao.mapper.TbItemParamMapper;
import com.sanmu.tao.pojo.*;
import com.sanmu.tao.service.ItemParamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-13 10:54
 **/
@Service
public class ItemParamServiceImpl implements ItemParamService {

    @Resource
    TbItemParamMapper itemParamMapper;

    @Override
    public EUDataGridResult getItemParamList(Integer page, Integer rows) {
        //查询商品列表
        TbItemParamExample example = new TbItemParamExample();
        //分页处理
        PageHelper.startPage(page, rows);
        List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<TbItemParam> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public TaotaoResult getItemParamByCid(Long itemCatId) {
        TbItemParamExample example = new TbItemParamExample();
        TbItemParamExample.Criteria criteria = example.createCriteria();
        criteria.andItemCatIdEqualTo(itemCatId);

        List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);

        if(list != null && list.size() > 0){
            return TaotaoResult.ok(list.get(0));
        }
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult insertItemParam(TbItemParam itemParam) {
        itemParam.setCreated(new Date());
        itemParam.setUpdated(new Date());
        itemParamMapper.insert(itemParam);
        return TaotaoResult.ok();
    }
}
