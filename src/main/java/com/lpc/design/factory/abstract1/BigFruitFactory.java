package com.lpc.design.factory.abstract1;

/**
 * ���幤����ɫ
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
