package com.lpc.design.decorator.example2;

/**
 * ����ı�װ����
 */
public class Person implements Human {

    @Override
    public void wearClothes() {
        System.out.println("��ʲô�ء���");
    }

    @Override
    public void walkToWhere() {
        System.out.println("ȥ�����ء���");
    }

}
