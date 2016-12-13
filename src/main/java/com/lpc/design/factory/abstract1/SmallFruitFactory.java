package com.lpc.design.factory.abstract1;

/**
 * 具体工厂角色
 */
public class SmallFruitFactory implements FruitFactory {
    @Override
    public Fruit createApple() {
        return new SmallApple();
    }

    @Override
    public Fruit createBanana() {
        return new SmallBanana();
    }
}
