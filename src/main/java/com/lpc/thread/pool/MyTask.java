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
        logger.info("正在执行线程 taskNum" + taskNum);
        try {
            Thread.currentThread().sleep(2000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("线程 taskNum" + taskNum + "执行完毕！");
    }

    public int getTaskNum() {
        return taskNum;
    }

    public void setTaskNum(int taskNum) {
        this.taskNum = taskNum;
    }
}
