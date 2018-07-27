package com.sanmu.tao.rest.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-27 15:35
 **/
public class ItemCat {
    //转换成json数据时使用u作为key
    @JsonProperty("u")
    private String url;

    @JsonProperty("n")
    private String name;

    @JsonProperty("i")
    private List<?> item;

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public List<?> getItem() {
        return item;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItem(List<?> item) {
        this.item = item;
    }
}
