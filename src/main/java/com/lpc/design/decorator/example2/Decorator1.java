package com.lpc.design.decorator.example2;

/**
 * �����װ����һ��ϸ��װ����
 */
public class Decorator1 extends Decorator {

    public Decorator1(Human human) {
        super(human);
    }

    public void wearClothes(){
        super.wearClothes();
        goHome();
    }

    public void walkToWhere(){
        super.walkToWhere();
        findMap();
    }

    public void goHome(){
        System.out.println("�����ӡ���");
    }

    public void findMap(){
        System.out.println("�鷿����Map����");
    }

}
