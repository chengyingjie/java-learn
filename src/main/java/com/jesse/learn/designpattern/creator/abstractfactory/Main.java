package com.jesse.learn.designpattern.creator.abstractfactory;

import com.jesse.learn.designpattern.creator.abstractfactory.fruit.Fruit;
import com.jesse.learn.designpattern.creator.abstractfactory.vegetable.Vegetable;

public class Main {

    public static void main(String[] args) {

        // 沙拉A套餐
        AbstractFactory saladSetA = new SaladSetAFactory();
        Fruit saladAFruit = saladSetA.createFruit();
        Vegetable saladAVegetable = saladSetA.createVegetable();
        System.out.println(saladAFruit.desc());
        System.out.println(saladAVegetable.desc());

        // 沙拉B套餐
        AbstractFactory saladSetB = new SaladSetBFactory();
        Fruit saladBFruit = saladSetB.createFruit();
        Vegetable saladBVegetable = saladSetB.createVegetable();
        System.out.println(saladBFruit.desc());
        System.out.println(saladBVegetable.desc());


        // 采用升级的抽象工厂
        UpgradeAbstractFactory abstractFactory = new UpgradeAbstractFactory(new SaladSetAFactory());
        SaladSet saladSet = abstractFactory.getSaladSet();
        System.out.println(saladSet.getSaladFruit().desc());
        System.out.println(saladSet.getSaladVegetable().desc());

    }
}
