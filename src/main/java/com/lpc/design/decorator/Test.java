package com.lpc.design.decorator;

/**
 * װ����ģʽ����
 */
public class Test {

    public static void main(String[] args) {
        Project employe = new Employe();
        Project managerA = new ManagerA(employe);
        Project managerB = new ManagerB(employe);
        managerA.doCoding();
        managerB.doCoding();
    }

}
