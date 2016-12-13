package com.lpc.design.singleton;

/**
 * ����ģʽ���̰߳�ȫʵ�ַ�ʽ3(ʹ��˫��ͬ����)
 */
public class SingletonThree {

    private static volatile SingletonThree singletonThree;

    private SingletonThree() {
    }

    public static SingletonThree getInstance() {
        if (singletonThree == null) {
            synchronized (SingletonThree.class) {
                if (singletonThree == null) {
                    singletonThree = new SingletonThree();
                }
            }
        }
        return singletonThree;
    }

}
