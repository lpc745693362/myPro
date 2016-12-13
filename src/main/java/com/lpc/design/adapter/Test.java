package com.lpc.design.adapter;

/**
 * Created by liupengcheng1 on 2016/11/17.
 */
public class Test {

    public static void main(String[] args) {
        Thing thing = new EatThing();
        Adapter adapter = new ConcreteAdapter(thing);
        adapter.doWhat();
    }

}
