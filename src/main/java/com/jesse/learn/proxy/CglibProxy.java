package com.jesse.learn.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLib底层采用ASM字节码生成框架，使用字节码技术生成代理类，比使用Java反射效率要高
 * 唯一需要注意的是，CGLib不能对声明为final的方法进行代理（final方法无法继承），因为CGLib原理是动态生成被代理类的子类。
 */
public class CglibProxy implements MethodInterceptor {

    // 要代理的原始对象
    private Object object;

    // 1 创建代理对象
    public Object createProxyInstance(Object object){
        this.object = object;

        // 1-Enhancer类是CGLib中的一个字节码增强器，它可以方便的对你想要处理的类进行扩展
        Enhancer enhancer = new Enhancer();

        // 2-将被代理类设置成父类
        enhancer.setSuperclass(this.object.getClass());

        // 3-设置拦截器
        enhancer.setCallback(this);

        // 4-动态生成一个代理类
        return enhancer.create();
    }


    // 2 实现MethodInterceptor的intercept方法
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

        System.out.println("before: " + method);

        //调用proxy.invoke()方法，会报java.lang.StackOverflowError错误，原因是invoke()内部会一直被反复调用 Object object = proxy.invoke(obj, args);
        Object object = proxy.invokeSuper(obj, args);

        System.out.println("after: " + method);

        return object;
    }

}
