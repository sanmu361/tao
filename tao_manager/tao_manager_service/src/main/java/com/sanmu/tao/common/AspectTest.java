package com.sanmu.tao.common;

import com.sanmu.tao.datasource.CustAnnotaion;
import com.sanmu.tao.datasource.DataSourceSwitch;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-18 11:25
 **/
@Aspect
public class AspectTest {

//    @Before("execution(* com.sanmu.tao.mapper.*.*(..))")
//    public void befor1(JoinPoint joinPoint) throws ClassNotFoundException {
//        //获得目标方法标签
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//
//        String sigName = methodSignature.getMethod().getAnnotation(CustAnnotaion.class).value();
//
//        //获得目标方法标签里的值
//      System.out.println("测试");
//
//    }
}
