package com.jesse.learn.designpattern.creator.abstractfactory;

import com.jesse.learn.designpattern.creator.abstractfactory.fruit.Fruit;
import com.jesse.learn.designpattern.creator.abstractfactory.vegetable.Vegetable;
import lombok.Data;

@Data
public class SaladSet {

    private Fruit saladFruit;

    private Vegetable saladVegetable;

}
