package com.jesse.learn.spring;


import java.util.UUID;

public class AnimalServiceImpl implements AnimalService {

    public void eat() {
        System.out.println("I want to eat...");
    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID());
    }
}
