package com.lpc.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;


public class ReadFileByChar {

    public static void readByChar(String fileName) {
        File file = new File(fileName);
        Reader reader = null;

        try {
            reader = new InputStreamReader(new FileInputStream(file));
            int tempChar;

            while ((tempChar = reader.read()) != -1) {
                if ((char) tempChar != '\r') {
                    System.out.print((char) tempChar);
                }
            }
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void readByChars(String fileName) {
        Reader reader = null;


        try {
            char[] tempChars = new char[50];
            int charRead = 0;
            reader = new InputStreamReader(new FileInputStream(fileName));
            while ((charRead = reader.read(tempChars)) != -1) {
                if ((charRead == tempChars.length) && (tempChars[tempChars.length - 1] != '\r')) {
                    System.out.print(tempChars);
                } else {
                    for (int i = 0; i < charRead; i++) {
                        if (tempChars[i] == '\r') {
                            continue;
                        } else {
                            System.out.print(tempChars[i]);
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
