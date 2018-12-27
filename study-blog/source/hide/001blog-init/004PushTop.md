# 置顶插件

### 安装插件
```
$ npm uninstall hexo-generator-index --save
$ npm install hexo-generator-index-pin-top --save
```
### 添加Front-matter配置
在需要置顶的文章的Front-matter中加上top: true

### 设置置顶标志样式
打开：/blog/themes/next/layout/_macro 目录下的post.swig文件，定位到<div class="post-meta">标签下，插入如下代码
```
{% if post.top %}
  <i class="fa fa-thumb-tack"></i>
  <font color=8B4513>置顶</font>
  <span class="post-meta-divider">|</span>
{% endif %}
```
### 参考链接
- https://blog.csdn.net/qwerty200696/article/details/79010629