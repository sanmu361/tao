package com.sanmu.tao.spring.common.datasource;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-18 17:46
 **/
public class DataSourceAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Source source = methodInvocation.getMethod().getAnnotation(Source.class);

        if(source != null){
            //获得目标方法标签里的值
            String sigName = source.value();

            //切换数据源
            DataSourceContextHolder.setDbType(sigName,source.propagation());

            try{
                //用改变的后的参数执行方法
                Object obj = methodInvocation.proceed();

                return obj;
            }catch (Exception e){
                throw  e;
            }finally {
                DataSourceContextHolder.clearDbType();
            }

        }
        return methodInvocation.proceed();
    }
}
