package com.pzhang7.study.java.designpattern.structure.facade;

/**
 * description: 其中一个子系统
 */
public class Memory {
    public void startup() {
        System.out.println("memory startup!");
    }

    public void shutdown() {
        System.out.println("memory shutdown");
    }
}
