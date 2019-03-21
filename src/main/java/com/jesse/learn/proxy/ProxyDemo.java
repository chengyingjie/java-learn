package com.jesse.learn.proxy;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class ProxyDemo {

    public static void main(String[] args) {

        List<String> imageList = new ArrayList<String>();
        imageList.add("https://avatars1.githubusercontent.com/u/3902527?v=4");
        imageList.add("https://avatars1.githubusercontent.com/u/3902527?v=4");
        String result = JSON.toJSONString(imageList);
        System.out.println("aaaa_" + JSON.toJSONString(imageList));
    }
}
