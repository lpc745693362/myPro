package com.lpc.thread;

import org.apache.log4j.Logger;

/**
 * Created by liupengcheng1 on 2016/5/17.
 */
public class HelloThread implements Runnable {

    private Logger logger = Logger.getLogger(HelloThread.class);

    private String name;

    public HelloThread() {

    }

    public HelloThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            logger.info("线程 " + name + " 运行  " + i);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String args[]) {
        HelloThread helloThread1 = new HelloThread("A");
        HelloThread helloThread2 = new HelloThread("B");

        Thread thread1 = new Thread(helloThread1);
        Thread thread2 = new Thread(helloThread2);

        thread1.start();
        thread2.start();
    }

}
