package com.lpc.design.command;

/**
 * ����ģʽ���ԣ�����һ��������������趨���Ľ�����
 */
public class Test {

    public static void main(String[] args) {
        // ����������
        Receiver receiver = new Receiver();
        // ����������󣬲������������
        Command command = new ConcreteCommand(receiver);
        // ���������ߣ�������������ý�ȥ
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        // ִ������
        invoker.runCommand();
        invoker.unDoCommand();
    }

}
