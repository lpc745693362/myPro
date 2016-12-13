package com.lpc.design.factory.method.example2;

import com.lpc.design.factory.method.Human;

/**
 * ���󹤳�
 */
public abstract class AbstractHumanFactory {

    public abstract <T extends Human> T createHuman(Class<T> clazz);

}
