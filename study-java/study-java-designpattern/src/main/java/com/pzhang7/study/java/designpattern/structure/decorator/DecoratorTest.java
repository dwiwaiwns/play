package com.pzhang7.study.java.designpattern.structure.decorator;

/**
 * Created by Zhang Peng on 2016/8/1.
 */
public class DecoratorTest {
    public static void main(String[] args) {
        Sourceable source = new Source();
        Sourceable obj = new Decorator(source);
        obj.method();
    }
}
