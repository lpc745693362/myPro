package com.lpc.design.factory.abstract1;

/**
 * 具体工厂角色
 */
public class BigFruitFactory implements FruitFactory {
    @Override
    public Fruit createApple() {
        return new BigApple();
    }

    @Override
    public Fruit createBanana() {
        return new BigBanana();
    }
}
