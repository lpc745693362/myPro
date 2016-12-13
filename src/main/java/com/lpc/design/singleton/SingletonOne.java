package com.lpc.design.singleton;

/**
 * 单例模式：线程安全实现方式1(饿汉模式)
 */
public class SingletonOne {

    // 非延迟加载，直接初始化一个对象
    private static SingletonOne singletonOne = new SingletonOne();

    // private类型的构造函数，保证其他类对象不能直接new一个该对象的实例
    private SingletonOne(){}

    public static SingletonOne getInstance(){
        return singletonOne;
    }

}
