package com.jesse.learn.designpattern.chainresponsibility.demo;

/**
 * 责任链模式简单demo
 */
public class Demo {

    public static void main(String[] args) {

        AbstractHandler concreteOne = new ConcreteOneHandler();
        AbstractHandler concretetwo = new ConcreteTwoHandler();
        AbstractHandler concretethree = new ConcreteThreeHandler();

        concreteOne.setAbstractHandler(concretetwo);
        concretetwo.setAbstractHandler(concretethree);

        concreteOne.handleRequest("three");
    }
}
