package com.jesse.learn.designpattern.chainresponsibility.demo;

/**
 * 具体处理者 —— two
 */
public class ConcreteTwoHandler extends AbstractHandler  {

    public void handleRequest(String condition) {

        if (condition.equals("two")) {
            System.out.println("ConcreteTwoHandler handleRequest");
        } else {
            System.out.println("ConcreteTwoHandler cannot do it");
            super.getAbstractHandler().handleRequest(condition);
        }
    }
}
