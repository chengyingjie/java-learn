package com.jesse.learn.designpattern.chainresponsibility.demo;

/**
 * 抽象处理者
 */
public abstract class AbstractHandler {

    private AbstractHandler abstractHandler;

    public void setAbstractHandler(AbstractHandler handler) {
        this.abstractHandler = handler;
    }

    public AbstractHandler getAbstractHandler() {
        return this.abstractHandler;
    }


    protected abstract void handleRequest(String condition);
}
