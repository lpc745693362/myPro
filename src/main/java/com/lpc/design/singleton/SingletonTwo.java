package com.lpc.design.singleton;

/**
 * ����ģʽ���̰߳�ȫʵ�ַ�ʽ2(ʹ��ͬ������)
 */
public class SingletonTwo {

    private static SingletonTwo singletonTwo;

    private SingletonTwo(){}

    // �Ի�ȡʵ���ķ�������ͬ����Ӱ��Ч��
    public static synchronized SingletonTwo getInstance(){
        if(singletonTwo == null){
            singletonTwo = new SingletonTwo();
        }
        return singletonTwo;
    }

}
