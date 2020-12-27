package cn.zhaosunny.svgmaplibrary;

import java.util.List;

/**
 * @author: zhaoSunny
 * @date: 2020-12-27
 * @action:
 */
public class SvgMapBean {

    public String svgMapName;

    public float svgMapWidth;
    public float svgMapHeight;

    public List<SvgPathBean> pathItems;


    public SvgMapBean(String svgMapName, float svgMapWidth, float svgMapHeight) {
        this.svgMapName = svgMapName;
        this.svgMapWidth = svgMapWidth;
        this.svgMapHeight = svgMapHeight;
    }
}
