package com.jesse.learn.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理是通过反射类Proxy以及InvocationHandler回调接口实现的
 * 要进行动态代理的类必须要实现一个接口
 */
public class JdkProxy implements InvocationHandler {

    private Object object;

    public Object createProxyInstance(Object object) {
        this.object = object;

        //创建并返回一个动态代理
        //这个动态代理与object实现了同样的接口，所以具有相同的public方法
        //所以动态代理对象可以当成object目标对象来使用
        //当程序调用了动态代理对象的指定方法，实际上转变为执行JdkProxy对象的invoke方法
        // ClassLoader loader:Java类加载器; 可以通过这个类型的加载器，在程序运行时，将生成的代理类加载到JVM即Java虚拟机中，以便运行时需要！
        // Class<?>[] interfaces:被代理类的所有接口信息; 便于生成的代理类可以具有代理类接口中的所有方法
        // InvocationHandler h:调用处理器; 调用实现了InvocationHandler 类的一个回调方法
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }

    /**
     * proxy : 把代理对象自己传递进来
     * method：把代理对象当前调用的方法传递进来
     * args:把方法参数传递进来
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("JdkProxy start");
        return method.invoke(object, args);
    }
}
