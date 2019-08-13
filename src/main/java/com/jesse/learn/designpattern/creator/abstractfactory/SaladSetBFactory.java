package com.jesse.learn.designpattern.creator.abstractfactory;

import com.jesse.learn.designpattern.creator.abstractfactory.fruit.Fruit;
import com.jesse.learn.designpattern.creator.abstractfactory.fruit.Grape;
import com.jesse.learn.designpattern.creator.abstractfactory.vegetable.Cabbage;
import com.jesse.learn.designpattern.creator.abstractfactory.vegetable.Vegetable;

public class SaladSetBFactory implements AbstractFactory {

    public Fruit createFruit() {
        return new Grape();
    }


    public Vegetable createVegetable() {
        return new Cabbage();
    }

}
