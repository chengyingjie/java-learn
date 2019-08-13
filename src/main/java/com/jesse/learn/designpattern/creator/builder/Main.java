package com.jesse.learn.designpattern.creator.builder;

import com.jesse.learn.designpattern.creator.abstractfactory.SaladSet;

public class Main {

    public static void main(String[] args) {

        Director directorA = new Director(new SaladSetAFactory());
        SaladSet saladSetA = directorA.construct();
        System.out.println(saladSetA.getSaladFruit().desc());
        System.out.println(saladSetA.getSaladVegetable().desc());

        Director directorB = new Director(new SaladSetBFactory());
        SaladSet saladSetB = directorB.construct();
        System.out.println(saladSetB.getSaladFruit().desc());
        System.out.println(saladSetB.getSaladVegetable().desc());
    }
}
