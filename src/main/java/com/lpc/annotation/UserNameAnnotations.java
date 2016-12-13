package com.lpc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD}) // 作用到接口，类，方法上
@Retention(RetentionPolicy.RUNTIME) // 在运行时可以获取
public @interface UserNameAnnotations {

    public String value() default ""; // 使用的时候 @UserNameAnnotations(value = "xxx")

}
