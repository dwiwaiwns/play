package com.pzhang7.study.java.designpattern.behavior.interpreter;

/**
 * @author pengz
 * @date created on 2018-10-8
 * @description
 */
public class TerminalExpression implements Expression {

    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        if (context.contains(data)) {
            return true;
        }
        return false;
    }
}
