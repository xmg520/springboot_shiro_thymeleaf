package com.mzx.shiromzx209.entity;

import java.io.Serializable;

public class Movie implements Serializable {
    private Integer id;
    private Integer uid;
    private Integer mid;
    private String name;
    private String url;

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", uid=" + uid +
                ", mid=" + mid +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
