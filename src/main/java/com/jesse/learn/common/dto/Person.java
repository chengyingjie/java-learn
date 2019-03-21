package com.jesse.learn.common.dto;

import lombok.Data;

@Data
public class Person {

    /**
     * 人员姓名
     */
    private String name;

    /**
     * 人员联系方式
     */
    private String tel;

    /**
     * 人员身高，单位:cm
     */
    private Integer height;

}
