package com.lpc.annotation;


public class TestUserName {

    public static void main(String[] args) {

        Class<UserName> userNameClass = UserName.class;
        //��Ϊע����������������ģ����Կ���ͨ��isAnnotationPresent���ж��Ƿ���һ��
        //��UserNameAnnotationsע�����
        if (userNameClass.isAnnotationPresent(UserNameAnnotations.class)) {
            System.out.println("this is a Annotations class");
            //ͨ��getAnnotation���Ի�ȡע�����
            UserNameAnnotations userNameAnnotations = userNameClass.getAnnotation(UserNameAnnotations.class);
            if (userNameAnnotations != null) {
                System.out.println("value:" + userNameAnnotations.value());
            } else {
                System.out.println("null");
            }
        } else {
            System.out.println("this is not Annotations class");
        }
    }

}
