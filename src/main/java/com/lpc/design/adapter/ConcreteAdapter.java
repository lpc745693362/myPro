package com.lpc.design.adapter;

/**
 * Created by liupengcheng1 on 2016/11/17.
 */
public class ConcreteAdapter implements Adapter {

    private Thing thing;

    public ConcreteAdapter(Thing thing){
        this.thing = thing;
    }

    @Override
    public void doWhat() {
        thing.doThing();
    }
}
