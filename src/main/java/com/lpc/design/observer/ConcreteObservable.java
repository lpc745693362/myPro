package com.lpc.design.observer;

import java.util.Observable;

/**
 * 被观察者：自身状态改变时会通知所有观察者
 */
public class ConcreteObservable extends Observable {

    int date = 0;

    public void setDate(int i){
        this.date = i;
        setChanged();
        notifyObservers();
    }

}
