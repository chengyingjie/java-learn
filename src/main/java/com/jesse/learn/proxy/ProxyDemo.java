package com.jesse.learn.proxy;

import com.alibaba.fastjson.JSON;
import com.jesse.learn.common.dto.Person;
import com.jesse.learn.common.service.PersonService;
import com.jesse.learn.common.service.PersonServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class ProxyDemo {

    public static void main(String[] args) {

        List<String> imageList = new ArrayList<>();
        imageList.add("https://avatars1.githubusercontent.com/u/3902527?v=4");
        imageList.add("https://avatars1.githubusercontent.com/u/3902527?v=4");
        System.out.println("aaaa_" + JSON.toJSONString(imageList));

        Person person = new Person();
        person.setHeight(175);
        person.setName("class class");
        person.setTel("15107162533");

        // 实例化需要代理的类
        PersonService personService = new PersonServiceImpl();
        System.out.println(personService.printPersonJson(person));

        // JDK动态代理
        PersonService proxyPersionService = (PersonService) (new JdkProxy()).createProxyInstance(personService);
        System.out.println(proxyPersionService.printPersonJson(person));

        // CGLIB动态代理
        // 1 实例化代理工厂
        CglibProxy cglibProxy = new CglibProxy();
        PersonServiceImpl personServiceImpl = new PersonServiceImpl();
        // 2 动态生成一个代理类
        PersonServiceImpl cglibPersonService =(PersonServiceImpl) cglibProxy.createProxyInstance(personServiceImpl);
        // 3 执行动态代理类的方法
        System.out.println(cglibPersonService.printPersonJson(person));
    }
}
