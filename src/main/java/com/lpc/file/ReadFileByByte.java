package com.lpc.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class ReadFileByByte {

    public static void readByByte(String fileName) {
        File file = new File(fileName);
        InputStream in = null;

        try {
            in = new FileInputStream(file);
            int tempByte;
            while ((tempByte = in.read()) != -1) {
                System.out.write(tempByte);
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readByBytes(String fileName) {
        InputStream in = null;

        try {
            byte[] tempBytes = new byte[100];
            int byteRead = 0;
            in = new FileInputStream(fileName);
            while ((byteRead = in.read(tempBytes)) != -1) {
                System.out.write(tempBytes, 0, byteRead);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
