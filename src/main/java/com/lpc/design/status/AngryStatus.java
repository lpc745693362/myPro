package com.lpc.design.status;

/**
 * 具体状态角色：生气状态
 */
public class AngryStatus implements Status {

    @Override
    public void action() {
        System.out.println("咬牙切齿！");
    }

}
