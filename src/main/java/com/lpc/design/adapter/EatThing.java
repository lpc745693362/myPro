package com.lpc.design.adapter;

/**
 * Created by liupengcheng1 on 2016/11/17.
 */
public class EatThing implements Thing {

    @Override
    public void doThing() {
        System.out.println("老板，来个煎饼果子，加十个鸡蛋。。。");
    }
}
