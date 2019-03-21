package com.jesse.learn.mybatis.demo;

import lombok.Data;

import java.util.Date;

@Data
public class KolDO {

    private Long id;

    private Long kdtId;
    private String teamName;
    private String name;
    private int gender;
    private Date createdAt;
    private Date updatedAt;
}
