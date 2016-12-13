package com.lpc.design.decorator.example2;

/**
 * 具体的被装饰者
 */
public class Person implements Human {

    @Override
    public void wearClothes() {
        System.out.println("穿什么呢。。");
    }

    @Override
    public void walkToWhere() {
        System.out.println("去哪里呢。。");
    }

}
