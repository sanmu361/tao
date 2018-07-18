package com.sanmu.tao.spring.common.datasource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-17 21:09
 **/
@Aspect
public class DataSourceSwitch {

    @Around("execution(* com.sanmu.tao.mapper.*.*(..))")
    public Object befor(ProceedingJoinPoint point) throws Throwable {
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
