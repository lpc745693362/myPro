package com.lpc.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liupengcheng1 on 2016/5/18.
 */
public class test {

    public static void main(String[] args) {
        Map map = Collections.synchronizedMap(new HashMap());
    }

}
