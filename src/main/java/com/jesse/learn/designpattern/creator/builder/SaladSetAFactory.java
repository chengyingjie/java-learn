package com.jesse.learn.designpattern.creator.builder;

import com.jesse.learn.designpattern.creator.abstractfactory.SaladSet;
import com.jesse.learn.designpattern.creator.abstractfactory.fruit.Apple;
import com.jesse.learn.designpattern.creator.abstractfactory.vegetable.Radish;

public class SaladSetAFactory implements AbstractFactory {

    private SaladSet saladSet = new SaladSet();


    public void createFruit() {
        saladSet.setSaladFruit(new Apple());
    }

    public void createVegetable() {
        saladSet.setSaladVegetable(new Radish());
    }

    public SaladSet getCreateResult() {
        return saladSet;
    }
}
