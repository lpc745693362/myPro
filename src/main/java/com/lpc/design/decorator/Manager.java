package com.lpc.design.decorator;

/**
 * 项目经理
 */
public class Manager implements Project {

    private Project project;

    public Manager(Project project){
        this.project = project;
    }

    @Override
    public void doCoding() {
        doManagerWork();
    }

    /**
     * 定义项目经理自己的事情
     */
    public void doManagerWork(){
        doEarlyWork();
        project.doCoding();
        doEndWork();
    }

    /**
     * 项目经理在做早期工作
     */
    public void doEarlyWork(){

    }

    /**
     * 项目经理在做收尾工作
     */
    public void doEndWork(){

    }

}
