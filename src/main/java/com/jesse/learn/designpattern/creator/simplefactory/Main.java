package com.jesse.learn.designpattern.creator.simplefactory;

import com.jesse.learn.designpattern.creator.Fruit;

public class Main {

    public static void main(String[] args) {

        // 造一个苹果
        Fruit apple = SimpleFactory.createFruit("apple");
        apple.desc();

        // 造一颗葡萄
        Fruit grape = SimpleFactory.createFruit("grape");
        grape.desc();
    }
}
