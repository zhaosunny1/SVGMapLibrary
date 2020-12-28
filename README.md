### Android 使用SVG 地图

[![](https://jitpack.io/v/zhaosunny1/SVGMapLibrary.svg)](https://jitpack.io/#zhaosunny1/SVGMapLibrary)

  用于加载SVG地图，可以控制显示地图上面每个区域的颜色，可以点击。

### 效果图如下

![screen](https://github.com/zhaosunny1/SVGMapLibrary/blob/master/screen/map.png)


### 如何使用


>  build.gradle中配置引入
```groovy
allprojects {
	repositories {
		maven { url 'https://jitpack.io' }
	}
}

dependencies {
    implementation 'com.github.zhaosunny1:SVGMapLibrary:0.2-alpha'
}
```

>  XML中配置

```XML
<cn.zhaosunny.svgmaplibrary.SvgMapView
    android:id="@+id/mapview"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintLeft_toLeftOf="parent"
    app:layout_constraintRight_toRightOf="parent"
    app:layout_constraintTop_toTopOf="parent"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />
```
>  Activity中使用

``` java
new Thread(new Runnable() {
      @Override
      public void run() {
       final SvgMapBean mapBean = VectorXmlUtil.getXmlValue(MainActivity.this,
                 R.raw.changezhou_maps, "常州市地图");
       runOnUiThread(new Runnable() {
           @Override
           public void run() {
               mapview.loadPathItemAndScale(mapBean);
           }
       });
                
      }
}).start();
```

>  修改颜色

``` java
mapview.setTextColor("#ff00ff");
mapview.pathItems.get(0).setColor("#00ff00");
//使用完后刷新数据
mapview.notifyDataSetChanged();
```
### MIT License


Copyright 2020 zhaosunny1

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.


