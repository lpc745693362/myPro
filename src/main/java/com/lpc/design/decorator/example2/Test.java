package com.lpc.design.decorator.example2;

/**
 * װ����ģʽ���ԣ���java��I/O��������
 */
public class Test {

    public static void main(String[] args) {
        Human person = new Person();
        // ��person���ϲ��װ��
        Decorator decorator = new Decorator3(new Decorator2(new Decorator1(person)));
        decorator.wearClothes();
        System.out.println("=====================");
        decorator.walkToWhere();
    }

}
