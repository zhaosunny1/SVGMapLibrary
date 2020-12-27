package com.huruwo.mapview.mapview;

import java.util.List;

/**
 * @author: liuwan
 * @date: 2018-02-01
 * @action:
 */
public class MapBean {

    public String map_name;

    public float map_w;
    public float map_h;

    public List<PathItem> pathItems;


    public MapBean(String map_name, float map_w, float map_h) {
        this.map_name = map_name;
        this.map_w = map_w;
        this.map_h = map_h;
    }
}
