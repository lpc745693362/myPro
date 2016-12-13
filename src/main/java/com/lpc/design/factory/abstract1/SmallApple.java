package com.lpc.design.factory.abstract1;

/**
 * 具体产品角色
 */
public class SmallApple extends Apple {

    @Override
    public void get() {
        System.out.println("捡到一个小苹果！");
    }

}
