package com.pzhang7.study.java.designpattern.structure.facade;

/**
 * description: 其中一个子系统
 */
public class CPU {
    public void startup() {
        System.out.println("cpu startup!");
    }

    public void shutdown() {
        System.out.println("cpu shutdown");
    }
}
