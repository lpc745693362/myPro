package com.lpc.design.command;

/**
 * 命令模式测试：创建一个具体命令对象并设定它的接收者
 */
public class Test {

    public static void main(String[] args) {
        // 创建接受者
        Receiver receiver = new Receiver();
        // 创建命令对象，并设置其接收者
        Command command = new ConcreteCommand(receiver);
        // 创建调用者，将命令对象设置进去
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        // 执行命令
        invoker.runCommand();
        invoker.unDoCommand();
    }

}
