package com.lpc.design.status;

/**
 * ������ɫ�����г���״̬������
 */
public class PersonL {

    private Status status;

    public void setStatus(Status status) {
        this.status = status;
    }

    public void todo(){
        status.action();
    }

}
