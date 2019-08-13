package com.jesse.learn.designpattern.creator.builder;

import com.jesse.learn.designpattern.creator.abstractfactory.SaladSet;
import com.jesse.learn.designpattern.creator.abstractfactory.fruit.Grape;
import com.jesse.learn.designpattern.creator.abstractfactory.vegetable.Cabbage;

public class SaladSetBFactory implements AbstractFactory {

    private SaladSet saladSet = new SaladSet();


    public void createFruit() {
        saladSet.setSaladFruit(new Grape());
    }

    public void createVegetable() {
        saladSet.setSaladVegetable(new Cabbage());
    }

    public SaladSet getCreateResult() {
        return saladSet;
    }
}
