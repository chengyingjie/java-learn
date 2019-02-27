package com.jesse.learn.designpattern.chainresponsibility.demo;

/**
 * 具体处理者 —— one
 */
public class ConcreteOneHandler extends AbstractHandler {

    public void handleRequest(String condition) {

        if (condition.equals("one")) {
            System.out.println("ConcreteOneHandler handleRequest");
        } else {
            System.out.println("ConcreteOneHandler cannot do it");
            super.getAbstractHandler().handleRequest(condition);
        }
    }
}
