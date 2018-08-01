package com.sanmu.tao.spring.common.datasource;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2016-07-18 16:18
 **/
public class DataSourceContextHolder {
    private static final ThreadLocal<String> dataSourceHolder = new ThreadLocal<String>();

    public static void setDbType(String dbType){
        dataSourceHolder.set(dbType);
    }

    public static String getDbType(){
        return (String)dataSourceHolder.get();
    }

    public static void clearDbType(){
        dataSourceHolder.remove();
    }
}
