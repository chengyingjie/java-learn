package com.jesse.learn.designpattern.creator.singleton;

public class DoubleCheckSingleton {

    private DoubleCheckSingleton() {}

    /**
     * 注意这里加了 volatile 关键字
     */
    private static volatile DoubleCheckSingleton singleton;

    public static DoubleCheckSingleton getInstance() {
        if (singleton == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (singleton == null) {
                    return new DoubleCheckSingleton();
                }
            }
        }

        return singleton;
    }

    public static void main(String[] args) {
        DoubleCheckSingleton.getInstance();
    }
}
