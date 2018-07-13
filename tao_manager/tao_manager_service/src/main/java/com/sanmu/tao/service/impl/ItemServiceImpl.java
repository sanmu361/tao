package com.sanmu.tao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sanmu.tao.IDUtils.IDUtils;
import com.sanmu.tao.mapper.TbItemDescMapper;
import com.sanmu.tao.mapper.TbItemMapper;
import com.sanmu.tao.mapper.TbItemParamItemMapper;
import com.sanmu.tao.pojo.*;
import com.sanmu.tao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-04 17:25
 **/
@Service
public class ItemServiceImpl implements ItemService {

    @Resource
    private TbItemMapper itemMapper;

    @Resource
    private TbItemDescMapper itemDescMapper;

    @Resource
    private TbItemParamItemMapper itemParamItemMapper;

    @Override
    public EUDataGridResult getItemList(int page, int rows) {

        //查询商品列表
        TbItemExample example = new TbItemExample();
        //分页处理
        PageHelper.startPage(page, rows);
        List<TbItem> list = itemMapper.selectByExample(example);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public TaotaoResult createItem(TbItem item, String desc, String itemParams) throws Exception {
        Long itemId = IDUtils.getItemId();

        item.setId(itemId);
        item.setStatus((byte)1);
        item.setCreated(new Date());
        item.setUpdated(new Date());
        itemMapper.insert(item);
        TaotaoResult result = insertItemDesc(itemId,desc);

        if(result.getStatus() != 200){
            throw new Exception();
        }

        result = insertItemParamItem(itemId,itemParams);
        if(result.getStatus() != 200){
            throw new Exception();
        }
        return TaotaoResult.ok();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public TaotaoResult updateItem(TbItem item, String desc, String itemParams) throws Exception {
        Long itemId = item.getId();


        item.setUpdated(new Date());
        itemMapper.updateByPrimaryKeySelective(item);
        TaotaoResult result = updateItemDesc(itemId,desc);

        if(result.getStatus() != 200){
            throw new Exception();
        }
        result = updateItemParamItem(itemId,itemParams);
        if(result.getStatus() != 200){
            throw new Exception();
        }
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult getItemDesc(Long itemId) {
        TbItemDesc tbItemDesc = itemDescMapper.selectByPrimaryKey(itemId);
        TaotaoResult taotaoResult = TaotaoResult.ok();
        taotaoResult.setData(tbItemDesc);
        return taotaoResult;
    }

    @Override
    public TaotaoResult getItemParam(Long itemId) {
        TbItemParamItem tbItemParamItem = itemParamItemMapper.selectByPrimaryKey(itemId);
        TaotaoResult taotaoResult = TaotaoResult.ok();
        taotaoResult.setData(tbItemParamItem);
        return taotaoResult;
    }

    /**
     * 添加商品描述
     * <p>Title: insertItemDesc</p>
     * <p>Description: </p>
     * @param desc
     */
    private TaotaoResult insertItemDesc(Long itemId, String desc) {
        TbItemDesc itemDesc = new TbItemDesc();
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(new Date());
        itemDesc.setUpdated(new Date());
        itemDescMapper.insert(itemDesc);
        return TaotaoResult.ok();
    }

    private TaotaoResult updateItemDesc(Long itemId, String desc) {
        TbItemDesc itemDesc = new TbItemDesc();
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setUpdated(new Date());
        itemDescMapper.updateByPrimaryKeySelective(itemDesc);
        return TaotaoResult.ok();
    }



    /**
     * 添加规格参数
     * <p>Title: insertItemParamItem</p>
     * <p>Description: </p>
     * @param itemId
     * @param itemParam
     * @return
     */
    private TaotaoResult insertItemParamItem(Long itemId, String itemParam) {
        //创建一个pojo
        TbItemParamItem itemParamItem = new TbItemParamItem();
        itemParamItem.setItemId(itemId);
        itemParamItem.setParamData(itemParam);
        itemParamItem.setCreated(new Date());
        itemParamItem.setUpdated(new Date());
        //向表中插入数据
        itemParamItemMapper.insert(itemParamItem);

        return TaotaoResult.ok();

    }

    private TaotaoResult updateItemParamItem(Long itemId, String itemParams) {
        //创建一个pojo
        TbItemParamItem itemParamItem = new TbItemParamItem();
        itemParamItem.setItemId(itemId);
        itemParamItem.setParamData(itemParams);
        itemParamItem.setUpdated(new Date());
        //向表中插入数据
        itemParamItemMapper.updateByPrimaryKeySelective(itemParamItem);

        return TaotaoResult.ok();
    }

}
