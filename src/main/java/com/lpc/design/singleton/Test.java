package com.lpc.design.singleton;

/**
 * ���Ե���ģʽ�Ƿ��̰߳�ȫ��hashCdoeֵһ�£��̰߳�ȫ
 */
public class Test extends Thread {

    public static void main(String[] args) {
        Test[] testOnes = new Test[50];
        for (int i = 0; i < testOnes.length; i++) {
            testOnes[i] = new Test();
        }

        for (int j = 0; j < testOnes.length; j++) {
            testOnes[j].start();
        }
    }

    // ��ӡ���������hashCodeֵ���۲��Ƿ�һ��
    public void run() {
        System.out.println(SingletonThree.getInstance().hashCode());
    }

}
