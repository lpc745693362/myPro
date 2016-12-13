package com.lpc.export;

import java.io.File;

/**
 * Created by liupengcheng1 on 2016/8/11.
 */
public class Test {

    public static void main(String[] args) {
        File file = null;
        try {

            file = File.createTempFile("temp", ".txt");
            System.out.println("File path =============== " + file.getPath());
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
