package com.lpc.design.decorator.example2;

/**
 * 具体的装饰者一：细化装饰者
 */
public class Decorator1 extends Decorator {

    public Decorator1(Human human) {
        super(human);
    }

    public void wearClothes(){
        super.wearClothes();
        goHome();
    }

    public void walkToWhere(){
        super.walkToWhere();
        findMap();
    }

    public void goHome(){
        System.out.println("进房子。。");
    }

    public void findMap(){
        System.out.println("书房找找Map。。");
    }

}
