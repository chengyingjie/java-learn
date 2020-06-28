package com.jesse.learn.designpattern.creator.singleton;

/**
 * 饿汉模式创建对象实例
 */
public class SingleInstance {

    private static final SingleInstance instance = new SingleInstance();

    private SingleInstance() {}

    public SingleInstance getInstance() {
        return instance;
    }
}
