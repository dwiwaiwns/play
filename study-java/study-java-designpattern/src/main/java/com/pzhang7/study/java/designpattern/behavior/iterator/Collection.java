package com.pzhang7.study.java.designpattern.behavior.iterator;

/**
 * Created by Zhang Peng on 2016/8/2.
 */
public interface Collection {
    public Iterator iterator();

    public Object get(int index);

    public int size();
}
