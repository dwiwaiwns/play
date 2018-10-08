package com.pzhang7.study.java.designpattern.create.abstractfactory.test;

import com.pzhang7.study.java.designpattern.create.abstractfactory.Provider;
import com.pzhang7.study.java.designpattern.create.abstractfactory.SendMailFactory;
import com.pzhang7.study.java.designpattern.create.abstractfactory.Sender;

/**
 * Created by Zhang Peng on 2016/7/25.
 */
public class AbstractFactoryTest {
    public static void main(String[] arg0) {
        Provider provider = new SendMailFactory();
        Sender sender = provider.produce();
        sender.send();
    }
}
