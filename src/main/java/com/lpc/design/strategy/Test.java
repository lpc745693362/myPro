package com.lpc.design.strategy;

/**
 * ����ģʽ����
 */
public class Test {

    public static void main(String[] args) {
        Strategy strategy = new ConcreteStrategyA();
        Context context = new Context(strategy);
        context.todo();
    }

}
