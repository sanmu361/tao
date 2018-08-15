package com.sanmu.tao.spring.common.datasource;

import org.springframework.aop.aspectj.AbstractAspectJAdvice;
import org.springframework.aop.aspectj.AspectJPointcutAdvisor;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-31 17:21
 **/
public class DataSourceAspectJPointcutAdvisor extends AspectJPointcutAdvisor {
    public DataSourceAspectJPointcutAdvisor(AbstractAspectJAdvice advice) {
        super(advice);
    }
}
