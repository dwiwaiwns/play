package com.pzhang7.study.java.designpattern.behavior.strategy;

/**
 * Created by Zhang Peng on 2016/8/1.
 */
public class Multiply extends AbstractCalculator implements ICalculator {
    @Override
    public int calculate(String exp) {
        int[] arrayInt = split(exp, "\\*");
        return arrayInt[0] * arrayInt[1];
    }
}
