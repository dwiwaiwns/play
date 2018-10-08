package com.pzhang7.study.java.designpattern.behavior.mediator;

/**
 * @author pengz
 * @date created on 2018-10-8
 * @description
 */
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name){
        this.name  = name;
    }

    public void sendMessage(String message){
        ChatRoom.showMessage(this,message);
    }
}
