package com.lpc.design.factory.method;

/**
 * 工厂方法模式测试
 */
public class Test {

    public static void main(String[] args) {
        HumanFactory maleFactory = new MaleFactory();
        Human male = maleFactory.create();
        male.speak();

        HumanFactory femaleFactory = new FemaleFactory();
        Human female = femaleFactory.create();
        female.speak();
    }

}
