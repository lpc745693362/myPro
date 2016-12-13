package com.lpc.design.observer;

/**
 * 观察者模式测试
 */
public class Test {

    public static void main(String[] args) {
        ConcreteObservable concreteObservable = new ConcreteObservable();
        concreteObservable.addObserver(new ConcreteObserver());
        concreteObservable.setDate(1);
        concreteObservable.setDate(2);
        concreteObservable.setDate(3);
    }

}
