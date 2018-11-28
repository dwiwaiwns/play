package com.pzhang7.study.test.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

class Account {

    private int nameIndex;
    private AtomicInteger amount;

    public Account(int nameIndex, AtomicInteger amount) {
        this.nameIndex = nameIndex;
        this.amount = amount;
    }

    // get & set

    public void addAmount(int amount0) {
        amount.getAndIncrement();
    }

    public void reduceAmount(int amount0) {
        amount.getAndDecrement();
    }

    public String toString() {
        return "accountIndex: " + nameIndex + ", now amount: " + amount.get();
    }
}

class MyThread implements Runnable {

    private List<Account> accountList;
    private int threadIndex;
    private Random rand;

    public MyThread(List<Account> accountList, int index) {
        this.accountList = accountList;
        this.threadIndex = index;
        this.rand = new Random();
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            int accountCount = accountList.size();
            int indexOne = rand.nextInt(accountCount);
            int indexTwo = rand.nextInt(accountCount);
            while (indexTwo == indexOne) {
                indexTwo = rand.nextInt(accountCount);
            }

            Account one = accountList.get(indexOne);
            Account two = accountList.get(indexTwo);

            one.reduceAmount(1);
            two.addAmount(1);
            System.out.println("threadIndex[" + threadIndex + "]转账操作：" + indexOne + "->" + indexTwo);
        }
    }
}

/**
 * 1.20个账户，每个账户1w，10个线程，每个线程100次转账操作（随机两个账户，进行转账操作，每次转1块钱）
 * 2.如果不是1块钱，有可能会将金额减为负值，该怎么改动？
 */
public class Demo {

    public static void main(String[] arg0) {
        int accountNum = 20;
        int amount = 10000;
        int threadCount = 10;

        List<Account> accountList = new ArrayList<>(accountNum);
        for (int i = 0; i < accountNum; i++) {
            accountList.add(new Account(i, new AtomicInteger(amount)));
        }

        List<Thread> threadList = new ArrayList<>(threadCount);
        for (int i = 0; i < threadCount; i++) {
            Thread t = new Thread(new MyThread(accountList, i));
            threadList.add(t);
            t.start();
        }

        for (int i = 0; i < threadCount; i++) {
            try {
                threadList.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < accountNum; i++) {
            System.out.println(accountList.get(i).toString());
        }

    }

}