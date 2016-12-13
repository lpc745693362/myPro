package com.lpc.design.strategy;

/**
 * ²ßÂÔÄ£Ê½²âÊÔ
 */
public class Test {

    public static void main(String[] args) {
        Strategy strategy = new ConcreteStrategyA();
        Context context = new Context(strategy);
        context.todo();
    }

}
