package com.pzhang7.study.annotation.core.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface Parameter {
    String value();
}

/**
 * Author: Zhang Peng
 * Date: 2017/2/7 0007
 * Description: 注解测试，验证注解需要使用反射机制进行解析
 */
public class AnnotationTest {

    public static void main(String[] args) {
        Dog dog = new Dog();
        setAnnotationFieldValue(dog);
        System.out.println(dog.getName());
    }

    public static void setAnnotationFieldValue(Object obj) {
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {

            String fieldName = field.getName();
            String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            try {
                Parameter parameter = field.getAnnotation(Parameter.class);
                if (parameter != null) {
                    Method method = obj.getClass().getMethod(methodName, new Class[]{String.class});
                    method.invoke(obj, new Object[]{parameter.value()});
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

class Dog {

    @Parameter(value = "hh")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
