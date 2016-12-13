package com.lpc.design.factory.method.example2;

import com.lpc.design.factory.method.Human;

/**
 * 具体工厂
 */
public class HumanFactory extends AbstractHumanFactory {

    @Override
    public <T extends Human> T createHuman(Class<T> clazz) {
        Human human = null;
        try{
            human = (Human)Class.forName(clazz.getName()).newInstance();
        } catch (Exception e){
            System.out.println("Human create error");
        }
        return (T)human;
    }
}
