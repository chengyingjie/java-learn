package com.jesse.learn.designpattern.creator.singleton;

/**
 * 懒汉方式实现单例模式
 */
public class LockSingleInstance {

    /**
     * 构造函数私有化
     */
    private LockSingleInstance() {}

    private static LockSingleInstance instance;


    /**
     * 不加锁，线程不安全
     */
    public static LockSingleInstance getInstanceWithoutLock() {
        if (instance == null) {
            return new LockSingleInstance();
        }

        return instance;
    }


    /**
     * 方法上加锁的方式创建单例
     * 缺点：线程安全，但方法级锁，效率不高
     */
    public static synchronized LockSingleInstance getInstanceWithMethodLock() {
        if (instance == null) {
            return new LockSingleInstance();
        }

        return instance;
    }

    /**
     * 双重检测，代码块加锁创建单例
     * 缺点：instance没有声明为volatile，结合对象创建过程（申请对象内存 -> 对象成员变量初始化 -> 变量和对象关联），会出现两个对象实例情况
     */
    public LockSingleInstance getInstanceWithoutDoubleLock() {

        if (instance == null) {
            synchronized (LockSingleInstance.class) {
                if (instance == null) {
                    return new LockSingleInstance();
                }
            }
        }

        return instance;
    }


}
