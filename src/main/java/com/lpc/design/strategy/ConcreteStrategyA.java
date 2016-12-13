package com.lpc.design.strategy;

/**
 * 具体策略角色A
 */
public class ConcreteStrategyA implements Strategy {

    @Override
    public void doSomething() {
        System.out.println("A doSomething...");
    }

}
