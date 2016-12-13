package com.lpc.design.observer;

import java.util.Observable;

/**
 * ���۲��ߣ�����״̬�ı�ʱ��֪ͨ���й۲���
 */
public class ConcreteObservable extends Observable {

    int date = 0;

    public void setDate(int i){
        this.date = i;
        setChanged();
        notifyObservers();
    }

}
