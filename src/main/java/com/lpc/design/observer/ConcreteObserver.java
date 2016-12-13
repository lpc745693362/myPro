package com.lpc.design.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者：被观察者状态改变时调用update方法
 */
public class ConcreteObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        ConcreteObservable concreteObservable = (ConcreteObservable)o;
        System.out.println("Data has change to：" + concreteObservable.date);
    }
}
