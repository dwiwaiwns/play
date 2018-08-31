---
title: IntrospectorCleanupListener的作用
date: 2018-06-21 11:30:00
tags: [Spring]
---

# IntrospectorCleanupListener作用

使用示例
```xml
<!--web.xml-->
<listener>
        <listener-class>org.springframework.web.util.IntrospectorCleanupListener</listener-class>
</listener>
```

## 作用：
1. 主要用于解决java.beans.Introspector导致的内存泄漏问题
2. 该监听器应该配置在web.xml中与Spring相关监听器中的第一个位置
3. 它是一个在web应用关闭的时候，清除JavaBeans Introspector的监听器。在web.xml中注册这个listener。可以保证在web 应用关闭的时候释放与掉这个web 应用相关的class loader 和由它管理的类


## 关于java.beans.Introspector

1. JDK中的java.beans.Introspector类的用途是发现Java类是否符合JavaBean规范，如果有的框架或程序用到了Introspector类，那么就会启用一个系统级别的缓存，此缓存会存放一些曾加载并分析过的JavaBean的引用。当Web服务器关闭时，由于此缓存中存放着这些JavaBean的引用，所以垃圾回收器无法回收Web容器中的JavaBean对象，最后导致内存变大。
2. 不幸的是，清除Introspector的唯一方式是刷新整个缓冲。这是因为我们没法判断哪些是属于你的应用的引用，所以删除被缓冲的introspection会导致把这台电脑上的所有应用的introspection都删掉。
3. 一些类库和框架往往会产生这个问题，例如:Struts 和 Quartz。

