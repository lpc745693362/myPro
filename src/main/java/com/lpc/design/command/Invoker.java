package com.lpc.design.command;

/**
 * 命令调用者
 */
public class Invoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * 执行命令
     */
    public void runCommand(){
        command.execute();
    }

    /**
     * 撤销命令
     */
    public void unDoCommand(){
        command.undo();
    }

}
