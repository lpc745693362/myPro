package com.lpc.design.decorator;

/**
 * ��Ŀ����B
 */
public class ManagerB extends Manager {

    public ManagerB(Project project) {
        super(project);
    }

    /**
     * ��Ŀ�����Լ������飺�����ڹ���
     */
    public void doEarlyWork() {
        System.out.println("��Ŀ����B �����������");
        System.out.println("��Ŀ����B ������ϸ���");
    }

    /**
     * ��Ŀ��������β����
     */
    public void doEndWork() {
        System.out.println("��Ŀ����B ������β����");
    }

}
