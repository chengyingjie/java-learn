package com.jesse.learn.designpattern.creator.factory;

import com.jesse.learn.designpattern.creator.Fruit;
import com.jesse.learn.designpattern.creator.Grape;

public class GrapeFactory implements Factory {

    public Fruit createFruit() {
        return new Grape();
    }
}
