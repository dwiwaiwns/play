package com.pzhang7.study.java.designpattern.create.factory;

/**
 * Created by Zhang Peng on 2016/7/25.
 */
public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("This is mail sender!");
    }
}
