# 文章末尾统一添加“本文结束”标记

### 新增"passage-end-tag.swig"配置文件
在路径\themes\next\layout\_macro中新建passage-end-tag.swig文件,并添加以下内容：
```html
<div>
    {% if not is_index %}
        <div style="text-align:center;color: #555;font-size:14px;">-------------The End-------------</div>
    {% endif %}
</div>
```
### 增加样式配置
打开\themes\next\layout\_macro\post.swig文件，在这个位置添加代码：
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
### 修改主题配置文件
在主题配置文件末尾添加以下内容
```text
# 文章末尾添加“本文结束”标记
passage_end_tag:
  enabled: true
```