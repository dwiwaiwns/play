# Theme

https://github.com/Ben02/hexo-theme-Anatole/wiki

http://theme-next.iissnan.com/getting-started.html

# 图片路径问题

### First
1 把主页配置文件_config.yml 里的post_asset_folder:这个选项设置为true

2 在你的hexo目录下执行这样一句话npm install hexo-asset-image --save，这是下载安装一个可以上传本地图片的插件，来自dalao：dalao的git

3 等待一小段时间后，再运行hexo n "xxxx"来生成md博文时，/source/_posts文件夹内除了xxxx.md文件还有一个同名的文件夹

### Second
4 最后在xxxx.md中想引入图片时，先把图片复制到xxxx这个文件夹中，然后只需要在xxxx.md中按照markdown的格式引入图片：

# 搜索
### 使用 local search
具体步骤参考next主题 local search 部分

# 流程图插件
https://github.com/bubkoo/hexo-filter-flowchart

# 置顶插件
https://blog.csdn.net/qwerty200696/article/details/79010629

# 计数插件

```shell
npm install hexo-wordcount --save
```

主题配置文件中：
```text
# Post wordcount display settings
# Dependencies: https://github.com/willin/hexo-wordcount
post_wordcount:
  item_text: true
  wordcount: true
  min2read: true
```

# RSS
1.安装 hexo-generator-feed插件
```sbtshell
npm install --save hexo-generator-feed
```
2.编辑站点配置文件
```text
feed: # RSS订阅插件
  type: atom
  path: atom.xml
  limit: 0

plugins: hexo-generate-feed
```
3.修改主题配置文件
```text
# Set rss to false to disable feed link.
# Leave rss as empty to use site's feed link.
# Set rss to specific value if you have burned your feed already.
rss: /atom.xml
```

# 文章末尾统一添加“本文结束”标记

1.在路径\themes\next\layout\_macro中新建passage-end-tag.swig文件,并添加以下内容：
```html
<div>
    {% if not is_index %}
        <div style="text-align:center;color: #555;font-size:14px;">-------------The End-------------</div>
    {% endif %}
</div>
```
2.打开\themes\next\layout\_macro\post.swig文件，在这个位置添加代码：
```html
    {#####################}
    {### END POST BODY ###}
    {#####################}
```
要添加的代码如下：
```html
<div>
  {% if not is_index %}
    {% include 'passage-end-tag.swig' %}
  {% endif %}
</div>
```
3.然后打开主题配置文件，在末尾添加：
```text
# 文章末尾添加“本文结束”标记
passage_end_tag:
  enabled: true
```


# 好友：
http://yefan95.github.io

https://blog.csdn.net/wk1134314305/article/details/74891419

https://zhidao.baidu.com/question/163063912.html?qq-pf-to=pcqq.discussion