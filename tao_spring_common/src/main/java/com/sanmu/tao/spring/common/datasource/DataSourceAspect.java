package com.sanmu.tao.spring.common.datasource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-18 20:59
 **/
public class DataSourceAspect {
    public Object around(ProceedingJoinPoint point) throws Throwable {
        //获得目标方法标签
        MethodSignature methodSignature = (MethodSignature) point.getSignature();

        Source source = methodSignature.getMethod().getAnnotation(Source.class);

        if(source != null){
            //获得目标方法标签里的值
            String sigName = source.value();

            //切换数据源
            DataSourceContextHolder.setDbType(sigName);

            //用改变的后的参数执行方法
            Object obj = point.proceed();

            DataSourceContextHolder.clearDbType();

            return obj;
        }
        return point.proceed();
    }
}
