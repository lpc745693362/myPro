package com.lpc.thread.pool;


import org.apache.log4j.Logger;

/**
 * Created by liupengcheng1 on 2016/5/17.
 */
public class MyTask implements Runnable {

    private Logger logger = org.apache.log4j.Logger.getLogger(MyTask.class);

    private int taskNum;

    public MyTask(int taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public void run() {
        logger.info("����ִ���߳� taskNum" + taskNum);
        try {
            Thread.currentThread().sleep(2000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("�߳� taskNum" + taskNum + "ִ����ϣ�");
    }

    public int getTaskNum() {
        return taskNum;
    }

    public void setTaskNum(int taskNum) {
        this.taskNum = taskNum;
    }
}
