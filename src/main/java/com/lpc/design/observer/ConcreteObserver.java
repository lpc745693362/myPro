package com.lpc.design.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * �۲��ߣ����۲���״̬�ı�ʱ����update����
 */
public class ConcreteObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        ConcreteObservable concreteObservable = (ConcreteObservable)o;
        System.out.println("Data has change to��" + concreteObservable.date);
    }
}
