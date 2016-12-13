package com.lpc.design.decorator;

/**
 * ��Ŀ����
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
     * ������Ŀ�����Լ�������
     */
    public void doManagerWork(){
        doEarlyWork();
        project.doCoding();
        doEndWork();
    }

    /**
     * ��Ŀ�����������ڹ���
     */
    public void doEarlyWork(){

    }

    /**
     * ��Ŀ����������β����
     */
    public void doEndWork(){

    }

}
