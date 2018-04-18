---
title: develop technology
date: 2018-04-17 13:00:00
tags: Utils
---

# Utils

***General***：Apache Commons 必备。尽量使用 3.0 以上版本。Guava 是 Google 推出的产品，新鲜的功能更多一些。

***JSON***：Jackon功能强大。

***XML***：据说 JDK 自带的 JAXB 就很好。

***Email***：直接用 Spring 的封装。

***Logging***：slf4j, log4j。

***Schedule***：使用 Spring 的 Schedule。

***时间日期***：JodaTime。

***io***：简单的文件 io 用 apache commons 或者 google guava。zip 文件处理用 zip4j。

***读取命令行参数***：JCommander是一个简单好用的命令行参数解析框架。

# Test

***Spring测试框架***：Spring Test/ testng。

***Mock***：Mockito 是现在最优雅简洁的 mock 框架了，强烈推荐使用。Mockito 搞不定的部分，比如static 函数，搭配 PowerMock。

***数据库测试***：使用 H2 Database 内存数据库。用 maven-surefire-plugin 多线程执行测试任务。

***功能测试***：使用 jetty-maven-plugin。

***Performance/Stability Test***：Jmeter。

