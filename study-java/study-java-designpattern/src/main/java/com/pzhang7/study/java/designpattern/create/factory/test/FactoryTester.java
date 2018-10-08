package com.pzhang7.study.java.designpattern.create.factory.test;

import com.pzhang7.study.java.designpattern.create.factory.Sender;
import com.pzhang7.study.java.designpattern.create.factory.SenderFactory;

/**
 * Created by Zhang Peng on 2016/7/25.
 */
public class FactoryTester {
    public static void main(String[] arg0) {
        try {
            SenderFactory senderFactory = new SenderFactory();
            Sender sender = senderFactory.produce("a");
            sender.send();
        } catch (Exception e) {
            System.out.println("创建Sender失败！");
        }
    }
}
