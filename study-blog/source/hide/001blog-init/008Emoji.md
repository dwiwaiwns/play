# emoji支持

### 1.安装markdown-it
```sbtshell
npm un hexo-renderer-marked --save
npm i hexo-renderer-markdown-it --save
```
### 2.安装markdown-it-emoji插件
```sbtshell
npm install markdown-it-emoji --save
```
### 3.配置站点_config.yml文件

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
### 4.使用使用twemoji表情

在markdown-it插件目录下clone twemoji
```sbtshell
git clone git@github.com:twitter/twemoji.git
```
### 5.配置markdown-it-emoji插件

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

### 6.修改twemoji样式——在主题CSS中添加自己的CSS代码

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
### 7.其他问题

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

#### 7.2.图片地址插件会失效
重装图片插件
#### 7.3.计数插件失效问题
重装字数统计插件

### 8.参考链接

- http://very9s.net/post/hexo-support-emoji/
- https://www.jianshu.com/p/57e22584b277

