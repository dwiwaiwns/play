package com.pzhang7.study.java.designpattern.behavior.mediator;

/**
 * @author pengz
 * @date created on 2018-10-8
 * @description 中介者模式
 */
public class MediatorPatternTest {

    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }

}
