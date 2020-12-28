package cn.zhaosunny.svgmaplibrary;

import android.graphics.Path;


/**
 * @author: zhaoSunny
 * @date: 2020年12月27日
 * @desc:
 */
public class SvgPathBean {
    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getXmlvalue() {
        return this.xmlvalue;
    }

    public void setXmlvalue(String xmlvalue) {
        this.xmlvalue = xmlvalue;
    }

    public boolean getIsSelect() {
        return this.isSelect;
    }

    public void setIsSelect(boolean isSelect) {
        this.isSelect = isSelect;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSelectedColor(String selectedColor) {
        this.selectedColor = selectedColor;
    }

    public String getSelectedColor() {
        return selectedColor;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
    }

    private Long id;

    private Path path;
    private String xmlvalue;
    private boolean isSelect;
    private String title;
    private int type;
    private String color, selectedColor;
    private int state;


    public SvgPathBean(String xmlvalue, boolean isSelect, String title,
                       int type, String color, int state, long mapid) {
        this.xmlvalue = xmlvalue;
        this.isSelect = isSelect;
        this.title = title;
        this.type = type;
        this.color = color;
        this.state = state;
    }

    public SvgPathBean() {
    }


}
