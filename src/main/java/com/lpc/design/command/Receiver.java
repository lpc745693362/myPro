package com.lpc.design.command;

/**
 * 命令接收者：命令真正执行人
 */
public class Receiver {

    /**
     * 接收者执行命令
     */
    public void action(){
        System.out.println("执行命令。。。");
    }

    /**
     * 接收者撤销命令
     */
    public void unAction(){
        System.out.println("撤销命令。。。");
    }

}
