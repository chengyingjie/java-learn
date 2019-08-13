package com.jesse.learn.designpattern.creator.factory;

public class Main {

    public static void main(String[] args) {

        // 构建苹果工厂
        Factory appleFactory = new AppleFactory();
        // 生产苹果
        Fruit apple = appleFactory.createFruit();
        apple.desc();

        // 构建葡萄工厂
        Factory grapeFactory = new AppleFactory();
        // 生产普通
        Fruit grape = grapeFactory.createFruit();
        grape.desc();


    }
}
