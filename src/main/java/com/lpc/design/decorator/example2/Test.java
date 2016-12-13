package com.lpc.design.decorator.example2;

/**
 * 装饰者模式测试：跟java的I/O操作相似
 */
public class Test {

    public static void main(String[] args) {
        Human person = new Person();
        // 给person加上层层装饰
        Decorator decorator = new Decorator3(new Decorator2(new Decorator1(person)));
        decorator.wearClothes();
        System.out.println("=====================");
        decorator.walkToWhere();
    }

}
