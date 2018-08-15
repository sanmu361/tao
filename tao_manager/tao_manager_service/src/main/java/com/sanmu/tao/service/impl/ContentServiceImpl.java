package com.sanmu.tao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Splitter;
import com.sanmu.tao.mapper.TbContentMapper;
import com.sanmu.tao.pojo.EUDataGridResult;
import com.sanmu.tao.pojo.TaotaoResult;
import com.sanmu.tao.pojo.TbContent;
import com.sanmu.tao.pojo.TbContentExample;
import com.sanmu.tao.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-27 18:27
 **/
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private TbContentMapper contentMapper;

    @Override
    public EUDataGridResult getContentList(long catId, Integer page, Integer rows) {
        //根据category_id查询内容列表
        TbContentExample example = new TbContentExample();
        TbContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(catId);
        //分页处理
        PageHelper.startPage(page, rows);
        List<TbContent> list = contentMapper.selectByExampleWithBLOBs(example);
        //取分页信息
        PageInfo<TbContent> pageInfo = new PageInfo<>(list);
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        result.setTotal(pageInfo.getTotal());
        return result;

    }

    @Override
    public TaotaoResult insertContent(TbContent content) {
        //补全pojo内容
        content.setCreated(new Date());
        content.setUpdated(new Date());
        contentMapper.insert(content);

//        //添加缓存同步逻辑
//        try {
//            HttpClientUtil.doGet(REST_BASE_URL + REST_CONTENT_SYNC_URL + content.getCategoryId());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        return TaotaoResult.ok();
    }


    @Override
    public TaotaoResult updateContent(TbContent content) {

        if (contentMapper.updateByPrimaryKeySelective(content) > 0){
            return TaotaoResult.ok();
        }else{
            return TaotaoResult.build(0,"更新错误！！！");
        }

    }

    @Override
    public int deleteContent(long id) {

        return contentMapper.deleteByPrimaryKey(id);

    }

    @Override
    public TaotaoResult deleteContents(String ids) {

        List<String> idList = Splitter.on(",").omitEmptyStrings().trimResults().splitToList(ids);

        for(String id : idList){
            deleteContent(Long.parseLong(id));
        }

        return TaotaoResult.ok();

    }
}
