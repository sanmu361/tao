package com.sanmu.tao.spring.common.datasource;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-31 12:29
 **/
public class SourceObject implements Comparable<SourceObject> {

    private String name;
    private Integer priority ;

    public SourceObject(String name, Integer priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(SourceObject sourceObject) {
        return sourceObject.priority.compareTo(this.priority) ;
    }
}
