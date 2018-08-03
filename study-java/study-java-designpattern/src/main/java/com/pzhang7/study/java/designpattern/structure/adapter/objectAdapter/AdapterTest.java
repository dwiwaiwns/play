package com.pzhang7.study.java.designpattern.structure.adapter.objectAdapter;

/**
 * Created by Zhang Peng on 2016/8/1.
 */
public class AdapterTest {
    public static void main(String[] arg0) {
        Source source = new Source();
        Targetable targetable = new Wrapper(source);
        targetable.method1();
        targetable.method2();
    }
}
