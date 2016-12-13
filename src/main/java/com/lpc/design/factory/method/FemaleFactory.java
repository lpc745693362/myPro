package com.lpc.design.factory.method;

/**
 * 创建女性工厂：具体工厂角色
 */
public class FemaleFactory implements HumanFactory {

    @Override
    public Human create() {
        System.out.println("创建一个女性！");
        return new Female();
    }
}
