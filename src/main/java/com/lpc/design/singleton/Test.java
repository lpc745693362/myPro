package com.lpc.design.singleton;

/**
 * 测试单例模式是否线程安全：hashCdoe值一致，线程安全
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

    // 打印单例对象的hashCode值，观察是否一致
    public void run() {
        System.out.println(SingletonThree.getInstance().hashCode());
    }

}
