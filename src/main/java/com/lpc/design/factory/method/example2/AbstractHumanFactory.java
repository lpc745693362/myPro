package com.lpc.design.factory.method.example2;

import com.lpc.design.factory.method.Human;

/**
 * ³éÏó¹¤³§
 */
public abstract class AbstractHumanFactory {

    public abstract <T extends Human> T createHuman(Class<T> clazz);

}
