package com.jesse.learn.designpattern.creator.simplefactory;

public class Main {

    public static void main(String[] args) {

        // 造一个苹果
        Fruit apple = SimpleFactory.createFruit("apple");
        System.out.println(apple.desc());

        // 造一颗葡萄
        Fruit grape = SimpleFactory.createFruit("grape");
        System.out.println(grape.desc());
    }
}
