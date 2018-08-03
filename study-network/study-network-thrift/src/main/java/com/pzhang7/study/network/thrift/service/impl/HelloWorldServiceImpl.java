package com.pzhang7.study.network.thrift.service.impl;

import com.pzhang7.study.network.thrift.service.HelloWorldService;
import org.apache.thrift.TException;

/**
 * Author: Zhang Peng
 * Date: 2017/1/23 0023
 * Description:
 */
public class HelloWorldServiceImpl implements HelloWorldService.Iface {
    @Override
    public String sayHello(String username) throws TException {
        return "Hi," + username + " welcome!";
    }
}
