package com.lpc.design.decorator;

/**
 * 程序员写代码
 */
public class Employe implements Project {

    @Override
    public void doCoding() {
        System.out.println("程序员在写代码，加班啊 加班啊，终于写完了！");
    }
}
