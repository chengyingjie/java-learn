package com.jesse.learn.designpattern.creator.abstractfactory;

public class UpgradeAbstractFactory {

    private AbstractFactory abstractFactory;


    UpgradeAbstractFactory(AbstractFactory abstractFactory) {
        this.abstractFactory = abstractFactory;
    }

    public SaladSet getSaladSet() {

        SaladSet saladSet = new SaladSet();
        saladSet.setSaladFruit(this.abstractFactory.createFruit());
        saladSet.setSaladVegetable(this.abstractFactory.createVegetable());

        return saladSet;
    }


}
