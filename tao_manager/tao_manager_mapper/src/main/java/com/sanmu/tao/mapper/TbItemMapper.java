package com.sanmu.tao.mapper;

import com.sanmu.tao.pojo.TbItem;
import com.sanmu.tao.pojo.TbItemExample;
import java.util.List;
import java.util.Map;

import com.sanmu.tao.spring.common.datasource.Source;
import org.apache.ibatis.annotations.Param;
import org.aspectj.lang.annotation.DeclareAnnotation;

public interface TbItemMapper {
    int countByExample(TbItemExample example);

    int deleteByExample(TbItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbItem record);

    int insertSelective(TbItem record);

    List<TbItem> selectByExample(TbItemExample example);

    @Source("taotao1")
    List<TbItem> selectByExample1(TbItemExample example);

    TbItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbItem record, @Param("example") TbItemExample example);

    int updateByExample(@Param("record") TbItem record, @Param("example") TbItemExample example);

    int updateByPrimaryKeySelective(TbItem record);

    int updateByPrimaryKey(TbItem record);

    @Source("test")
    Long selectAll();
}