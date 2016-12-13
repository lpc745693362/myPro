package com.lpc.design.strategy;

/**
 * ������ɫ�����г�����Խ�ɫ������
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
