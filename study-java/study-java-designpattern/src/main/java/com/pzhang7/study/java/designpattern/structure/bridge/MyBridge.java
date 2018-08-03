package com.pzhang7.study.java.designpattern.structure.bridge;

/**
 * Created by Zhang Peng on 2016/8/1.
 */
public class MyBridge extends Bridge {
    public void method() {
        getSource().method();
    }
}
