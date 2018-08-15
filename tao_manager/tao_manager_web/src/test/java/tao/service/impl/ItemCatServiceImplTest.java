package tao.service.impl;


import com.sanmu.tao.mapper.TbItemMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-20 17:21
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/applicationContext.xml" })
public class ItemCatServiceImplTest {

    @Resource
    private TbItemMapper itemMapper;


    @Test
    public void getItemCatList() {
         Long list =  itemMapper.selectAll();
        System.out.println(list);
    }
}