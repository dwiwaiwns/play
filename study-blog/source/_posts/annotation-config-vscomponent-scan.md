---
title: <context:annotation-config> VS <context:component-scan>
date: 2018-06-08 15:38:00
tags: [Spring]
---

# <context:annotation-config> 跟 <context:component-scan>的区别

#### ***<context:annotation-config>*** 用于激活那些已经在spring容器里注册过的bean（无论是通过xml的方式还是通过package sanning的方式）上面的注解，是一个注解处理工具。

#### ***<context:component-scan>*** 除了具有<context:annotation-config>的功能之外，<context:component-scan>还可以在指定的package下扫描以及注册Java Bean。

【重点】context:annotation-config只处理注册过的bean

参考：

- https://stackoverflow.com/questions/7414794/difference-between-contextannotation-config-vs-contextcomponent-scan/
- https://www.cnblogs.com/leiOOlei/p/3713989.html
- https://blog.csdn.net/baple/article/details/16864835

找到好几个完全一样的帖子（日志打印出来对象的ID都一样），我已经傻傻分不清原创（手动捂脸），倾向于stackoverflow原创吧