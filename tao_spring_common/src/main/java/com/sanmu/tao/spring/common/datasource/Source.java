package com.sanmu.tao.spring.common.datasource;

import java.lang.annotation.*;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-17 21:04
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Inherited
public @interface Source {

    public String value() default "default";

    public boolean propagation() default false;
}
