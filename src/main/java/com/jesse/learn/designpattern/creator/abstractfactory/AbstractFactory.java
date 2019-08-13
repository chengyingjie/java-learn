package com.jesse.learn.designpattern.creator.abstractfactory;


import com.jesse.learn.designpattern.creator.abstractfactory.fruit.Fruit;
import com.jesse.learn.designpattern.creator.abstractfactory.vegetable.Vegetable;

public interface AbstractFactory {

    Fruit createFruit();

    Vegetable createVegetable();

}
