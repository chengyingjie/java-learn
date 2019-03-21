package com.jesse.learn.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring AOP demo
 */
public class BeanDemo {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        AnimalService animalService = (AnimalService) ctx.getBean("animalService");
        animalService.eat();

//        ClassPathResource resource = new ClassPathResource("beans.xml");
//        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
//        reader.loadBeanDefinitions(resource);
//
//        AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext();


    }
}
