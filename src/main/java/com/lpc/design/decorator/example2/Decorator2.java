package com.lpc.design.decorator.example2;

/**
 * �����װ���߶���ϸ��װ����
 */
public class Decorator2 extends Decorator {

    public Decorator2(Human human) {
        super(human);
    }

    public void wearClothes(){
        super.wearClothes();
        goClothespress();
    }

    public void walkToWhere(){
        super.walkToWhere();
        findPlaceOnMap();
    }

    public void goClothespress(){
        System.out.println("ȥ�¹����ҿ�����");
    }

    public void findPlaceOnMap(){
        System.out.println("��Map�����ҡ���");
    }

}
