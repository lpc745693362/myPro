package com.lpc.design.singleton;

/**
 * ����ģʽ���̰߳�ȫʵ�ַ�ʽ1(����ģʽ)
 */
public class SingletonOne {

    // ���ӳټ��أ�ֱ�ӳ�ʼ��һ������
    private static SingletonOne singletonOne = new SingletonOne();

    // private���͵Ĺ��캯������֤�����������ֱ��newһ���ö����ʵ��
    private SingletonOne(){}

    public static SingletonOne getInstance(){
        return singletonOne;
    }

}
