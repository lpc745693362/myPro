package com.lpc.design.factory.method;

/**
 * 具体产品角色：男性
 */
public class Male implements Human {

    @Override
    public void speak() {
        System.out.println("男性说话：呜呜呜呜。。。");
    }

}
