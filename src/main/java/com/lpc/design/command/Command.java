package com.lpc.design.command;

/**
 * ���������ɫ
 */
public interface Command {

    /**
     * ִ������
     */
    public void execute();

    /**
     * ��������
     */
    public void undo();

}
