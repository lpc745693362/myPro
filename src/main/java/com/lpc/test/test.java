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
        printCallStatck();
    }

    public static void printCallStatck() {
        Throwable ex = new Throwable();
        StackTraceElement[] stackElements = ex.getStackTrace();
        if (stackElements != null) {
            for (int i = 0; i < stackElements.length; i++) {
                System.out.print(stackElements[i].getClassName() + "/t");
                System.out.print(stackElements[i].getFileName() + "/t");
                System.out.print(stackElements[i].getLineNumber() + "/t");
                System.out.println(stackElements[i].getMethodName());
                System.out.println("-----------------------------------");
            }
        }
    }

}
