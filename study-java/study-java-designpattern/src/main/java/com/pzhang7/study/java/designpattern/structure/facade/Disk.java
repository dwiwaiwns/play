package com.pzhang7.study.java.designpattern.structure.facade;

/**
 * description: 其中一个子系统
 */
public class Disk {
    public void startup() {
        System.out.println("disk startup!");
    }

    public void shutdown() {
        System.out.println("disk shutdown");
    }
}
