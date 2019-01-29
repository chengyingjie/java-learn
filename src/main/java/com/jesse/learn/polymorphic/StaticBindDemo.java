package com.jesse.learn.polymorphic;

public class StaticBindDemo {

    public static void main(String[] args) {

        ChildDTO childDTO = new ChildDTO();
        BaseDTO baseDTO = childDTO;

        System.out.println(baseDTO.staticValue);
        System.out.println(baseDTO.commonValue);
        baseDTO.staticMethod();

        System.out.println(childDTO.staticValue);
        System.out.println(childDTO.commonValue);
        childDTO.staticMethod();


        // result如下：
        // static_base
        // base
        // base static method:static_base
        // child_base
        // child
        // child static method:child_base
    }
}


