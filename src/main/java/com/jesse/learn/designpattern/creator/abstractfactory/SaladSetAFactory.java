package com.jesse.learn.designpattern.creator.abstractfactory;

import com.jesse.learn.designpattern.creator.abstractfactory.fruit.Apple;
import com.jesse.learn.designpattern.creator.abstractfactory.fruit.Fruit;
import com.jesse.learn.designpattern.creator.abstractfactory.vegetable.Radish;
import com.jesse.learn.designpattern.creator.abstractfactory.vegetable.Vegetable;

public class SaladSetAFactory implements AbstractFactory {

    public Fruit createFruit() {
        return new Apple();

    }

    public Vegetable createVegetable() {
        return new Radish();
    }
}
