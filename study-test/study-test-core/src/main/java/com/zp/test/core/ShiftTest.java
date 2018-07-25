package com.zp.test.core;

/**
 * @author: Zhang Peng
 * @date: created on 2018/6/28 0028 17:56
 * @description:
 */
public class ShiftTest {

    public static void main(String[] args) {
        ShiftTest.main2();
    }

    public static void main4() {
        int big = 12345;
        System.out.println(Integer.toBinaryString(12345));
        float approx = big;
        System.out.println(approx);
        System.out.println((int)approx);
        System.out.println(Integer.toBinaryString((int)approx));
        System.out.println(big - (int)approx);
    }

    public static void main3() {
        System.out.println((int)(char)(byte) -1);
    }

    public static void main2() {
        int i = -1;
        char c = (char) i;
        System.out.println(String.format("%-15s:%s", "c's binary str", Integer.toBinaryString(c)));
        System.out.println(String.format("%-15s:%s", "c's char", c));
        System.out.println(String.format("%-15s:%s", "(int)c1", (int) c));

        char c1 = (char) -1;
        System.out.println(String.format("%-15s:%s", "c1 binary str", Integer.toBinaryString(c1)));
        c1 >>= 15;
        System.out.println(String.format("%-15s:%s", "c1 >>>= 15", Integer.toBinaryString(c1)));

        char c2 = (char) -1;
        c2 >>= 17;
        System.out.println(String.format("%-15s:%s", "c2 >>>= 17", Integer.toBinaryString(c2)));

        char c3 = (char) -1;
        c3 >>= 31;
        System.out.println(String.format("%-15s:%s", "c3 >>>= 31", Integer.toBinaryString(c3)));

        char c4 = (char) -1;
        c4 >>= 33;
        System.out.println(String.format("%-15s:%s", "c4 >>>= 33", Integer.toBinaryString(c4)));
    }

    public static void main1() {
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
        byte c = -1;
        System.out.println(String.format("%-15s:%s", "byte c = -1:", Integer.toBinaryString(c)));
        System.out.println(String.format("%-15s:%s", "c >>>= 10:", Integer.toBinaryString(c >>> 10)));
    }
}
