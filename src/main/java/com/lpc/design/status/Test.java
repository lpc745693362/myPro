package com.lpc.design.status;

/**
 * ״̬ģʽ����
 */
public class Test {

    public static void main(String[] args) {
        Status status = new HappyStatus();
        PersonL personL = new PersonL();
        personL.setStatus(status);
        personL.todo();
    }

}
