package com.lpc.design.decorator.example2;

/**
 * �����װ��������ϸ��װ����
 */
public class Decorator3 extends Decorator {

    public Decorator3(Human human) {
        super(human);
    }

    public void findClothes() {
        System.out.println("�ҵ�һ�����硣��");
    }

    public void findTheTarget() {
        System.out.println("��Map���ҵ����ػ�԰�ͳǱ�����");
    }

    @Override
    public void wearClothes() {
        super.wearClothes();
        findClothes();
    }

    @Override
    public void walkToWhere() {
        super.walkToWhere();
        findTheTarget();
    }

}
