package com.lpc.design.singleton;

/**
 * 单例模式：线程安全实现方式2(使用同步方法)
 */
public class SingletonTwo {

    private static SingletonTwo singletonTwo;

    private SingletonTwo(){}

    // 对获取实例的方法进行同步：影响效率
    public static synchronized SingletonTwo getInstance(){
        if(singletonTwo == null){
            singletonTwo = new SingletonTwo();
        }
        return singletonTwo;
    }

}
