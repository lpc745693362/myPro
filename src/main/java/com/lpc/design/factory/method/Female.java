package com.lpc.design.factory.method;

/**
 * 具体产品角色：女性
 */
public class Female implements Human {

    @Override
    public void speak() {
        System.out.println("女性说话：哇哇哇哇。。。");
    }

}
