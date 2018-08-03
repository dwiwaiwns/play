package com.pzhang7.study.spring.aop.test;


import com.pzhang7.study.spring.aop.model.impl.Business;

/**
 * 使用自定义的类加载
 */
public class MyClassloader extends ClassLoader {

    public static void main(String[] args) {
        try {
            MyClassloader myClassloader = new MyClassloader();
            Class b = myClassloader.loadClass("model.Business");
            ((Business) b.newInstance()).doSomeThing();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
