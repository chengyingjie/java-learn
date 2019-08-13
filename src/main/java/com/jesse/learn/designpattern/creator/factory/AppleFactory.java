package com.jesse.learn.designpattern.creator.factory;

import com.jesse.learn.designpattern.creator.Apple;
import com.jesse.learn.designpattern.creator.Fruit;

public class AppleFactory implements Factory {

    public Fruit createFruit() {
        return new Apple();
    }
}
