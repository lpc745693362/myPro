package com.lpc.design.decorator;

/**
 * ��Ŀ����A
 */
public class ManagerA extends Manager {

    public ManagerA(Project project) {
        super(project);
    }

    /**
     * ��Ŀ�����Լ������飺�����ڹ���
     */
    public void doEarlyWork() {
        System.out.println("��Ŀ����A �����������");
        System.out.println("��Ŀ����A �����ܹ����");
        System.out.println("��Ŀ����A ������ϸ���");
    }

}
