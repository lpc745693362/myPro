package com.lpc.thread.pool;

import org.apache.log4j.Logger;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by liupengcheng1 on 2016/5/17.
 */
public class ThreadPoolTest {

    private static Logger logger = Logger.getLogger(ThreadPoolTest.class);

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(10));

        for(int i=0; i< 20; i++){
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);

            logger.info("线程池中线程数目：" + executor.getPoolSize() + "， 队列中等待执行的任务数目：" +
                executor.getQueue().size() + "，已执行完的任务数目：" + executor.getCompletedTaskCount());

        }

        executor.shutdown();

    }

}
