package com.jesse.learn.designpattern.chainresponsibility.demo;

/**
 * 具体处理者 —— three
 */
public class ConcreteThreeHandler extends AbstractHandler {

    public void handleRequest(String condition) {

        if (condition.equals("three")) {
            System.out.println("ConcreteThreeHandler handleRequest");
        } else {
            System.out.println("ConcreteThreeHandler cannot do it");
            super.getAbstractHandler().handleRequest(condition);
        }
    }
}
