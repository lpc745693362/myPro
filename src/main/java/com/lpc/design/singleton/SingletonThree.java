package com.lpc.design.singleton;

/**
 * 单例模式：线程安全实现方式3(使用双重同步锁)
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
