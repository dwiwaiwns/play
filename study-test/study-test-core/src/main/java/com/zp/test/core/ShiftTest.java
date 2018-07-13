package com.zp.test.core;

/**
 * @author: Zhang Peng
 * @date: created on 2018/6/28 0028 17:56
 * @description:
 */
public class ShiftTest {

    public static void main1(String[] args) {
        System.out.println(-1 << 1);
        // char c = (char) -1;
        // System.out.println(c);
    }

    public static void main(String[] args) {
        char c2=(char)-1;
        c2>>=17;
        System.out.println(Integer.toBinaryString(c2));
    }

    public static void main2(String[] args) {
        // int i = -1;
        // System.out.println(Integer.toBinaryString(i));
        // i >>>= 10;
        // System.out.println(Integer.toBinaryString(i));
        // long l = -1;
        // System.out.println(Long.toBinaryString(l));
        // l >>>= 10;
        // System.out.println(Long.toBinaryString(l));
        // short s = -1;
        // System.out.println(Integer.toBinaryString(s));
        // s >>>= 10;
        // System.out.println(Integer.toBinaryString(s));
        // byte b = -1;
        // System.out.println(Integer.toBinaryString(b));
        // b >>>= 10;
        // System.out.println(Integer.toBinaryString(b));
        // b = -1;
        // System.out.println(Integer.toBinaryString(b));
        // System.out.println(Integer.toBinaryString(b>>>10));

        int i = -1;
        System.out.println(String.format("%-15s:%s", "int i = -1", Integer.toBinaryString(i)));
        i >>>= 10;
        System.out.println(String.format("%-15s:%s", "i >>>= 10", Integer.toBinaryString(i)));
        long l = -1;
        System.out.println(String.format("%-15s:%s", "long l = -1", Long.toBinaryString(l)));
        l >>>= 10;
        System.out.println(String.format("%-15s:%s", "l >>>= 10", Long.toBinaryString(l)));
        short s = -1;
        System.out.println(String.format("%-15s:%s", "short s = -1", Integer.toBinaryString(s)));
        s >>>= 10;
        System.out.println(String.format("%-15s:%s", "s >>>= 10", Integer.toBinaryString(s)));
        byte b = -1;
        System.out.println(String.format("%-15s:%s", "byte b = -1", Integer.toBinaryString(b)));
        b >>>= 10;
        System.out.println(String.format("%-15s:%s", "b >>>= 10", Integer.toBinaryString(b)));
        b = -1;
        System.out.println(String.format("%-15s:%s", "byte b = -1:", Integer.toBinaryString(b)));
        System.out.println(String.format("%-15s:%s", "b >>>= 10:", Integer.toBinaryString(b >>> 10)));
    }
}
