package com.lpc.design.factory.abstract1;

/**
 * 抽象工厂模式测试
 */
public class Test {

    public static void main(String[] args) {
        FruitFactory smallFruitFactory = new SmallFruitFactory();
        Fruit smallApple = smallFruitFactory.createApple();
        Fruit smallBanana = smallFruitFactory.createBanana();
        smallApple.get();
        smallBanana.get();

        FruitFactory bigFruitFactory = new BigFruitFactory();
        Fruit bigApple = bigFruitFactory.createApple();
        Fruit bigBanana = bigFruitFactory.createBanana();
        bigApple.get();
        bigBanana.get();
    }

}
