package com.jesse.learn.designpattern.creator.factory;

public class GrapeFactory implements Factory {

    public Fruit createFruit() {
        return new Grape();
    }
}
