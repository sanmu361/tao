package com.sanmu.tao.portal.service.impl;

import com.sanmu.tao.portal.pojo.ADItem;
import com.sanmu.tao.utils.HttpClientUtils;
import com.sanmu.tao.pojo.TaotaoResult;
import com.sanmu.tao.pojo.TbContent;
import com.sanmu.tao.portal.service.AdService;
import com.sanmu.tao.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-27 19:54
 **/
@Service
public class AdServiceImpl implements AdService {

    @Value("${REST_BASE_URL}")
    private String REST_BASE_URL;
    @Value("${REST_INDEX_AD_URL}")
    private String REST_INDEX_AD_URL;

    @Override
    public String getContentList() throws Exception {
        //调用服务层的服务
        String result = HttpClientUtils.doGet(REST_BASE_URL + REST_INDEX_AD_URL);
        //把字符串转换成TaotaoResult

            TaotaoResult taotaoResult = TaotaoResult.formatToList(result, TbContent.class);
            //取内容列表
            List<TbContent> list = (List<TbContent>) taotaoResult.getData();
            List<ADItem> resultList = new ArrayList<>();
            //创建一个jsp页码要求的pojo列表
            for (TbContent tbContent : list) {
                ADItem item = new ADItem();
                item.setHeight(240);
                item.setWidth(670);
                item.setSrc(tbContent.getPic());
                item.setHeightB(240);
                item.setWidth(550);
                item.setSrcB(tbContent.getPic2());
                item.setAlt(tbContent.getTitleDesc());
                item.setHref(tbContent.getUrl());
                resultList.add(item);

            }
            return JsonUtils.objectToJson(resultList);
    }
}
