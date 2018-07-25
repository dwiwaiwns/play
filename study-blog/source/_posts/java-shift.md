---
title: Java移位
date: 2018-06-28 11:30:00
tags: [Java]
---

```
移位操作是针对于二进制数来说的，二进制基础，本文不做讲解
```

### 1.Java的数据类型字节长度

```
byte:8bits
int:32bits
char:16bits
short:16bits
long:64bits
boolean:-
float:32bits
double:64bits
```

### 2.Java的数据类型取值范围
![data range](java-shift/01-data-range.png)<br/>

### 3.移位操作
移位操作符有左移位<<、右移位>>和无符号右移>>>，当然类似于+=这种操作符，也有<<=和>>=

#### 3.1.左移
对于位数左移之后，低位的补0<br>
例如：3<<2，表示3向左移动两位，3的二进制表示是"11"，左移两位后是"1100"，也就是乘以4即等于12

#### 3.2.右移
和左移不一样的地方就是：如果被位移的数是负数，那么右移之后，高位全都补1；如果是正数，那么右移之后，高位全都补0。也就是正数依然是正数，负数依然是负数。

#### 3.3.无符号右移
这种移位操作与右移不同的地方就是：无论是正数还是负数，在移位之后，高位都补0。即移位之后永远都是正数。

【注】
```
（1）无论是左移还是右移（包括无符号右移），如果移动的位数超过规定的bit数，都会与最大移位数取模之后进行计算。
``` 

int类型，3<<33，其实就是3<<1；同理，右移和无符号右移也是一样 
long型数据，3<<65其实就是3<<1

```
（2）对于byte和short进行移位运算的时候，会被转换为int型。进行右移的时候，可能会对高位截断
    （byte和short本身比int字节少，因此转成int计算完毕，再转换回去的时候，可能会对高位截断）
``` 
例如：
```java
public class ShiftTest {

    public static void main(String[] args) {
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
```
输出结果：
```
int i = -1     :11111111111111111111111111111111
i >>>= 10      :1111111111111111111111
long l = -1    :1111111111111111111111111111111111111111111111111111111111111111
l >>>= 10      :111111111111111111111111111111111111111111111111111111
short s = -1   :11111111111111111111111111111111
s >>>= 10      :11111111111111111111111111111111
byte b = -1    :11111111111111111111111111111111
b >>>= 10      :11111111111111111111111111111111
byte c = -1:   :11111111111111111111111111111111
c >>>= 10:     :1111111111111111111111
```




