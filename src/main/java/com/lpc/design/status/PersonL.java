package com.lpc.design.status;

/**
 * 环境角色：持有抽象状态的引用
 */
public class PersonL {

    private Status status;

    public void setStatus(Status status) {
        this.status = status;
    }

    public void todo(){
        status.action();
    }

}
