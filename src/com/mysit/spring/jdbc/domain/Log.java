package com.mysit.spring.jdbc.domain;

import java.io.Serializable;
import java.util.Date;

public class Log implements Serializable {

    private static final long serialVersionUID = 5872830730374581584L;
    private Integer id;
    private String content;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
