package com.sanmu.tao.spring.common.datasource;

import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.PriorityQueue;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-18 16:18
 **/
public class DataSourceContextHolder {
    private static final ThreadLocal<PriorityQueue<SourceObject>> dataSourceHolder = new ThreadLocal<PriorityQueue<SourceObject>>();

    private static final ThreadLocal<Boolean> dataFlagHolder = new ThreadLocal<Boolean>();

    private static final ThreadLocal<Integer>  dataSourceFloorHolder = new ThreadLocal<Integer>();

    public static void setDbType(String dbType,boolean flag){
        if(dataSourceHolder.get() == null){
            dataSourceHolder.set(new PriorityQueue<SourceObject>());
        }
        if(dataSourceHolder.get().size() == 0){
            dataSourceHolder.get().add(new SourceObject(dbType,0));
            dataFlagHolder.set(flag);
            dataSourceFloorHolder.set(1);
            return;
        }
        if(dataFlagHolder.get()){
            dataSourceHolder.get().add(new SourceObject(dbType,dataSourceHolder.get().peek().getPriority() + 1));
        }
        dataSourceFloorHolder.set(dataSourceFloorHolder.get() + 1);
    }

    public static String getDbType(){
        return CollectionUtils.isEmpty((Collection)dataSourceHolder.get()) ? null : ((SourceObject)((PriorityQueue)dataSourceHolder.get()).peek()).getName();
    }

    public static void clearDbType(){

        dataSourceFloorHolder.set(dataSourceFloorHolder.get() - 1);
        SourceObject source = dataSourceHolder.get().poll();

        if(dataSourceFloorHolder.get() <= 0){
            dataSourceHolder.remove();
            dataFlagHolder.remove();
            dataSourceFloorHolder.remove();
        }
        if(source == null){
            dataSourceHolder.remove();
            dataFlagHolder.remove();
            dataSourceFloorHolder.remove();
        }

    }
}
