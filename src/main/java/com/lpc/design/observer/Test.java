package com.lpc.design.observer;

/**
 * �۲���ģʽ����
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
