### Android 使用SVG 地图
  用于加载SVG地图，可以控制显示地图上面每个区域的颜色，可以点击。

### 如何使用

> 0. build.gradle中配置引入
```groovy

```

> 1. XML中配置
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
> 2. Activity中使用
``` java
new Thread(new Runnable() {
            @Override
            public void run() {
                final SvgMapBean mapBean = VectorXmlUtil
                        .getXmlValue(MainActivity.this,
                        R.raw.changezhou_maps, "常州市地图");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mapview.loadPathItemAndScale(mapBean);
                    }
                });
                
            }
        }).start();
    }

```



### Mit Licenses

