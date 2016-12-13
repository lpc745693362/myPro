package com.lpc.design.strategy;

/**
 * 环境角色：持有抽象策略角色的引用
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public void todo(){
        strategy.doSomething();
    }

}
