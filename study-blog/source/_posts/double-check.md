---
title: Java单例模式双重锁（Double-Check）问题
date: 2018-06-21 11:30:00
tags: [Java,设计模式]
---

很久之前就看到过这个问题，但是并没有完全吃透，现在重新再理解了一次，就想记录下来。

进入正题，该模式的代码如下
```java
class Singleton{
    public static Singleton instance;
    public static Singleton getInstance(){
        if (instance == null) { // 1
            synchronized(Singleton.class) { // 2
                if (instance == null) // 3
                    instance = new Singleton(); // 4
            }
        }
        return instance;
    }
}
```
该模式是对下面代码的改进
```java
class Singleton{
    public static Singleton instance;
    public static Singleton getInstance(){
        if (instance == null) { 
            instance = new Singleton();
        }
        return instance;
    }
}
```
该模式目的是对 instance 延迟初始化。如果直接加同步锁，也就是保留2、3、4步骤，那么每次访问的时候都需要同步，增加了系统开销，于是有了双重检查模式。

但是最开始的代码块是有问题的，问题根源在哪呢？

实际存在的问题是无序性，第4步的操作其实分两个步骤，即分配内存和将 instance 指向内存
第4步这个new操作是无序的，它可能会被编译成：
 
- a. 先分配内存，让 instance 指向这块内存 
- b. 在内存中创建对象

或者：

- a. 在内存中创建对象
- a. 让 instance 指向这个对象

synchronized 虽然是互斥的，但是如果 new 被编译成第一种方式，线程 t1 执行到 a ，线程 t2 执行到 1。那么 t2 读到的 instance 就可能是 null ,也可能不是 null 。

如果读到的是null，反而没问题，接下来会继续等待 synchronized 锁；如果读到的不是 null，然后 return instanse，但是 instance 可能还没有执行构造方法，然后去调用的话，很有可能会出现其他问题

解决方案：

- 1.加 volatile
- 2.Initialization on Demand Holder（IODH）

方案2的代码如下：

```java
public class Singleton {  
    static class SingletonHolder {  
        static Singleton instance = new Singleton();  
    }  
      
    public static Singleton getInstance(){  
        return SingletonHolder.instance;  
    }  
}
```

参考：

- https://blog.csdn.net/dl88250/article/details/5439024
- https://blog.csdn.net/anjxue/article/details/51038466