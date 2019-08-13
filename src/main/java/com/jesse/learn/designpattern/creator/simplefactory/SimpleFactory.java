package com.jesse.learn.designpattern.creator.simplefactory;


public class SimpleFactory {

    public static Fruit createFruit(String name) {

        Fruit fruit = null;

        switch (name) {
            case "apple":
                fruit = new Apple();
                break;
            case "grape":
                fruit = new Grape();
                break;
            default:
                break;
        }

        return fruit;
    }


}
