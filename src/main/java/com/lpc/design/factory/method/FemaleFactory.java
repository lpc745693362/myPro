package com.lpc.design.factory.method;

/**
 * ����Ů�Թ��������幤����ɫ
 */
public class FemaleFactory implements HumanFactory {

    @Override
    public Human create() {
        System.out.println("����һ��Ů�ԣ�");
        return new Female();
    }
}
