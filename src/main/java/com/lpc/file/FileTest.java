package com.lpc.file;

import java.io.File;

/**
 * Created by liupengcheng1 on 2016/5/18.
 */
public class FileTest {

    public static void main(String[] args) {
        String path = "D:\\export";
        File file = new File(path);
        scanFile(file);
    }

    private static void scanFile(File file) {

        if (file.isDirectory()) {
            File fileList[] = file.listFiles();

            for (int i = 0; i < fileList.length; i++) {
                scanFile(fileList[i]);
            }

        } else if (file.isFile()) {
            System.out.println("file path£º" + file.getPath());
        }

    }

}
