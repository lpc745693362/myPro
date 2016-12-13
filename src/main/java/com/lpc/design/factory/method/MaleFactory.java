package com.lpc.design.factory.method;

/**
 * 创建男性工厂：具体工厂角色
 */
public class MaleFactory implements HumanFactory {

    @Override
    public Human create() {
        System.out.println("创建一个男性！");
        return new Male();
    }
}
