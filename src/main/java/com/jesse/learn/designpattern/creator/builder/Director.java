package com.jesse.learn.designpattern.creator.builder;

import com.jesse.learn.designpattern.creator.abstractfactory.SaladSet;

public class Director {

    private AbstractFactory abstractFactory;


    Director(AbstractFactory abstractFactory) {
        this.abstractFactory = abstractFactory;
    }

    public SaladSet construct() {

        this.abstractFactory.createFruit();
        this.abstractFactory.createVegetable();

        return this.abstractFactory.getCreateResult();
    }


}
