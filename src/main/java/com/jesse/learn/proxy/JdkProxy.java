package com.jesse.learn.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {

    private Object object;

    public Object createProxyInstance(Object object) {
        this.object = object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("JdkProxy start");
        return method.invoke(object, args);
    }
}
