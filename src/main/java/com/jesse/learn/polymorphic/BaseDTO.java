package com.jesse.learn.polymorphic;

public class BaseDTO {

    public static String staticValue = "static_base";
    public String commonValue = "base";

    public static void staticMethod(){
        System.out.println("base static method:" + staticValue);
    }
}
