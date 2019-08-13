package com.jesse.learn.designpattern.creator.simplefactory;

import com.jesse.learn.designpattern.creator.Apple;
import com.jesse.learn.designpattern.creator.Fruit;
import com.jesse.learn.designpattern.creator.Grape;

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
