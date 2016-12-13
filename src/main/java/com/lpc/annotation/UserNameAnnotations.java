package com.lpc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD}) // ���õ��ӿڣ��࣬������
@Retention(RetentionPolicy.RUNTIME) // ������ʱ���Ի�ȡ
public @interface UserNameAnnotations {

    public String value() default ""; // ʹ�õ�ʱ�� @UserNameAnnotations(value = "xxx")

}
