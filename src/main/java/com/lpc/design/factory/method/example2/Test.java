package com.lpc.design.factory.method.example2;

import com.lpc.design.factory.method.Female;
import com.lpc.design.factory.method.Human;
import com.lpc.design.factory.method.Male;

/**
 * 工厂方法模式测试2
 */
public class Test {

    public static void main(String[] args) {
        AbstractHumanFactory humanFactory = new HumanFactory();
        Human male = humanFactory.createHuman(Male.class);
        male.speak();

        Human female = humanFactory.createHuman(Female.class);
        female.speak();
    }

}
