package com.lpc.design.factory.method;

/**
 * �������Թ��������幤����ɫ
 */
public class MaleFactory implements HumanFactory {

    @Override
    public Human create() {
        System.out.println("����һ�����ԣ�");
        return new Male();
    }
}
