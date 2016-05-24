package com.lpc.user.entity;

import java.util.Date;

/**
 * Created by liupengcheng1 on 2016/5/16.
 */
public class User {

    private long id;
    private String name;
    private int age;
    private Date birthDay;

    public User(){

    }

    public User(long id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthDay = new Date();
    }

    public User(long id, String name, int age, Date birthDay) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthDay = birthDay;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "User{" +  "id=" + id + ", name='" + name + '\'' +  ", age=" + age + ", birthDay=" + birthDay + '}';
    }

}
