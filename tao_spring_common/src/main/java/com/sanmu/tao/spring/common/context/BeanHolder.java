package com.sanmu.tao.spring.common.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-18 21:12
 **/
@Component
public class BeanHolder implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeanHolder.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static <T> T getBean(String beanName) {
        return (T) applicationContext.getBean(beanName);
    }

    public static <T>T getBean(String beanName , Class<T>clazz) {
        return (T)applicationContext.getBean(beanName , clazz);
    }

    public static <T>T getBean(Class<T>clazz) {
        return (T)applicationContext.getBean(clazz);
    }
}
