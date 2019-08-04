package com.jesse.learn.common.service;

import com.alibaba.fastjson.JSON;
import com.jesse.learn.common.dto.Person;

public class PersonServiceImpl implements PersonService {


    public String printPersonJson(Person person) {
        return JSON.toJSONString(person);
    }
    
}
