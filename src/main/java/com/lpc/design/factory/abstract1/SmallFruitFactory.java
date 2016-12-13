package com.lpc.design.factory.abstract1;

/**
 * ���幤����ɫ
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
