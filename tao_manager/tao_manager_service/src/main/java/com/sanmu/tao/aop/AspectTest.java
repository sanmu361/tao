package com.sanmu.tao.aop;

import com.sanmu.tao.spring.common.datasource.DataSourceContextHolder;
import com.sanmu.tao.spring.common.datasource.Source;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.PriorityQueue;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-31 11:16
 **/
@Aspect
@Component
public class AspectTest {


    @Around("@annotation(source)")
    public Object befor(ProceedingJoinPoint point, Source source) throws Throwable {

        if(source != null){
            //获得目标方法标签里的值
            String sigName = source.value();

            //切换数据源
            DataSourceContextHolder.setDbType(sigName,source.propagation());

            try{
                //用改变的后的参数执行方法
                Object obj = point.proceed();

                return obj;
            }catch (Exception e){
                throw  e;
            }finally {
                DataSourceContextHolder.clearDbType();
            }
        }
        return point.proceed();
    }

}
