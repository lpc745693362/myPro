package com.lpc.annotation;

/**
 * ע��ע��������������
 * ����ͨ������ ��ȡ�����Ϣ֮�� ��ȡ�õ����ע���ֵ
 */
@UserNameAnnotations(value = "lpc")
public class UserName {

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
