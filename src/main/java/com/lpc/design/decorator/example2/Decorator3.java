package com.lpc.design.decorator.example2;

/**
 * 具体的装饰者三：细化装饰者
 */
public class Decorator3 extends Decorator {

    public Decorator3(Human human) {
        super(human);
    }

    public void findClothes() {
        System.out.println("找到一件披风。。");
    }

    public void findTheTarget() {
        System.out.println("在Map上找到神秘花园和城堡。。");
    }

    @Override
    public void wearClothes() {
        super.wearClothes();
        findClothes();
    }

    @Override
    public void walkToWhere() {
        super.walkToWhere();
        findTheTarget();
    }

}
