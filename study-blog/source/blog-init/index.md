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


# emoji支持

1.安装markdown-it
```sbtshell
npm un hexo-renderer-marked --save
npm i hexo-renderer-markdown-it --save
```
2.安装markdown-it-emoji插件
```sbtshell
npm install markdown-it-emoji --save
```
3.配置站点_config.yml文件

增加以下配置代码
```sbtshell
markdown:
  render:
    html: true
    xhtmlOut: false
    breaks: true
    linkify: true
    typographer: true
    quotes: '“”‘’'
  plugins:
    - markdown-it-abbr
    - markdown-it-footnote
    - markdown-it-ins
    - markdown-it-sub
    - markdown-it-sup
    - markdown-it-emoji  #用emoji插件
  anchors:
    level: 2
    collisionSuffix: 'v'
    permalink: true
    permalinkClass: header-anchor
    permalinkSymbol: ¶
```
4.使用使用twemoji表情

在markdown-it插件目录下clone twemoji
```sbtshell
git clone git@github.com:twitter/twemoji.git
```
5.配置markdown-it-emoji插件

修改markdown-it-emoji的index.js，增加内容，我的文件修改后如下：
```text
'use strict';



var emojies_defs      = require('./lib/data/full.json');
var emojies_shortcuts = require('./lib/data/shortcuts');
var emoji_html        = require('./lib/render');
var emoji_replace     = require('./lib/replace');
var normalize_opts    = require('./lib/normalize_opts');
var twemoji           = require('./twemoji')  //添加twemoji

module.exports = function emoji_plugin(md, options) {
  var defaults = {
    defs: emojies_defs,
    shortcuts: emojies_shortcuts,
    enabled: []
  };

  var opts = normalize_opts(md.utils.assign({}, defaults, options || {}));

  md.renderer.rules.emoji = emoji_html;
  //使用 twemoji 渲染
  md.renderer.rules.emoji = function(token, idx) {
    return twemoji.parse(token[idx].content);
  };

  md.core.ruler.push('emoji', emoji_replace(md, opts.defs, opts.shortcuts, opts.scanRE, opts.replaceRE));
};
```

6.修改twemoji样式——在主题CSS中添加自己的CSS代码

我使用的是next主题，配置文件在"themes\next\source\css\_custom\custom.styl"
```css
.posts-expand .post-body .emoji {
  margin: auto;
  padding: 0px;
  border: 0px;
  height: 1.3em;
  display:inline-block;
}
```
因为我的.posts-expand .post-body img 配置有其他属性的缘故，所以我的配置是上面这种方式，你可以使用下面的配置即可
```css
.emoji {
  // 你自己的配置
}
```
7.其他问题

7.1.我配置完成之后，表情会换行并居中，由于我自己对css其实不太熟练，我参考了简书上面一篇博客，修改了如下配置
```js
$('.content img')
      .not('[hidden]')
      .not('.group-picture img, .post-gallery img')
	  .not('img.emoji') // 这一行是我新加的配置
      .each(function () {
        var $image = $(this);
        var imageTitle = $image.attr('title');
        var $imageWrapLink = $image.parent('a');

        if ($imageWrapLink.size() < 1) {
	        var imageLink = ($image.attr('data-original')) ? this.getAttribute('data-original') : this.getAttribute('src');
          $imageWrapLink = $image.wrap('<a href="' + imageLink + '"></a>').parent('a');
        }

        $imageWrapLink.addClass('fancybox fancybox.image');
        $imageWrapLink.attr('rel', 'group');

        if (imageTitle) {
          $imageWrapLink.append('<p class="image-caption">' + imageTitle + '</p>');

          //make sure img title tag will show correctly in fancybox
          $imageWrapLink.attr('title', imageTitle);
        }
      });
```
我修改的文件是"themes\next\source\js\src\utils.js"

7.2.图片地址会失效问题

重装图片插件即可

8.参考链接

1. http://very9s.net/post/hexo-support-emoji/
2. https://www.jianshu.com/p/57e22584b277



# 好友：
http://yefan95.github.io

https://blog.csdn.net/wk1134314305/article/details/74891419

https://zhidao.baidu.com/question/163063912.html?qq-pf-to=pcqq.discussion