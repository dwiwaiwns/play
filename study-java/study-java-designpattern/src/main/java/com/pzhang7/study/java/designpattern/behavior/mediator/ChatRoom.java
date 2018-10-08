package com.pzhang7.study.java.designpattern.behavior.mediator;

import java.util.Date;

/**
 * @author pengz
 * @date created on 2018-10-8
 * @description
 */
public class ChatRoom {
    public static void showMessage(User user, String message){
        System.out.println(new Date().toString()
                + " [" + user.getName() +"] : " + message);
    }
}
