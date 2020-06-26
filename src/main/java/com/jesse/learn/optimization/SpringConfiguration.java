package com.jesse.learn.optimization;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// @Configuration 相当于 spring 配置文件中的 beans 标签 <beans></beans>
// 该类一般被称为配置类
@Configuration
// 相当于 context:component-scan 标签
@ComponentScan(basePackages = "com.jesse.learn.optimization")
// 引入其他配置类，多用于分模块开发
@Import(DemoConfiguration.class)
public class SpringConfiguration {

    public SpringConfiguration() {
        System.out.println("SpringConfiguration 容器初始化···");
    }

    // Bean 注解（相当于配置文件中的 bean 标签），可以指定 beanId，使用 value 属性指定；如果不指定，默认的 beanId 就是当前被注解方法的方法名称
    /*@Bean(value = "requestMerge")
    public RequestMerge requestMerge() {
        return new RequestMerge();
    }*/
}
