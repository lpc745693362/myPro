package com.lpc.annotation;

/**
 * 注入注解作用与类上面
 * 可以通过反射 获取类的信息之后 获取得到这个注解的值
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
