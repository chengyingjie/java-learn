package com.jesse.learn.designpattern.creator.builder;


import com.jesse.learn.designpattern.creator.abstractfactory.SaladSet;

public interface AbstractFactory {

    void createFruit();

    void createVegetable();

    SaladSet getCreateResult();

}
