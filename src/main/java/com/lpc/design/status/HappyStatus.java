package com.lpc.design.status;

/**
 * 具体状态角色：高兴状态
 */
public class HappyStatus implements Status {

    @Override
    public void action() {
        System.out.println("俏皮可爱！");
    }

}
