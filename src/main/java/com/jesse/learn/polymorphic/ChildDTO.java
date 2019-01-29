package com.jesse.learn.polymorphic;

public class ChildDTO extends BaseDTO {

    public static String staticValue = "child_base";
    public String commonValue = "child";

    public static void staticMethod(){
        System.out.println("child static method:" + staticValue);
    }
}
