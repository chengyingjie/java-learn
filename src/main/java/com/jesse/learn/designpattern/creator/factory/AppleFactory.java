package com.jesse.learn.designpattern.creator.factory;


public class AppleFactory implements Factory {

    public Fruit createFruit() {
        return new Apple();
    }
}
