package cn.zhaosunny.svgmaplibrary;

import android.content.Context;
import android.util.Log;

import androidx.annotation.RawRes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * @author: zhaoSunny
 * @date: 2020年12月27日
 * @action:
 */
public class VectorXmlUtil {

    public static int MAP_TYPE_CITY = 0;
    public static int MAP_TYPE_POINT = 1;

    public static int STATE_WELL = 0;
    public static int STATE_FAULT = 1;

    /**
     * 请注意，要在子线程中运行，不要在UI线程中调用。
     *
     * @param context
     * @param raw_res
     * @param map_name
     * @return
     * @author zhaosunny
     */
    public static SvgMapBean getXmlValue(Context context, @RawRes final int raw_res, String map_name) {

        SvgMapBean mapBean = null;

        List<SvgPathBean> pathlists = new ArrayList<>();

        try {
            // DocumentBuilder对象

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            //打开输入流
            InputStream is = context.getResources().openRawResource(raw_res);


            // 获取文档对象
            Document doc = db.parse(is);

            //根节点
            Element element = doc.getDocumentElement();

            //Log.e("android:viewportWidth",element.getAttribute("android:viewportWidth"));
            //Log.e("android:viewportHeight",element.getAttribute("android:viewportHeight"));

            float map_w = Float.valueOf(element.getAttribute("android:viewportWidth"));
            float map_h = Float.valueOf(element.getAttribute("android:viewportHeight"));

            //获取path元素节点集合
            NodeList paths = doc.getElementsByTagName("path");


            mapBean = new SvgMapBean(map_name, map_w, map_h);

            for (int i = 0; i < paths.getLength(); i++) {
                // 取出每一个元素
                Element node = (Element) paths.item(i);
                //得到android:pathData属性值
                String pathValue = node.getAttribute("android:pathData");
                String colorValue = node.getAttribute("android:fillColor");
                String nameValue = "";
                if (node.hasAttribute("android:name")) {
                    nameValue = node.getAttribute("android:name");
                }
                //String nameValue = "地点：" + i;
                SvgPathBean item = new SvgPathBean(pathValue, false, nameValue,
                        MAP_TYPE_CITY,
                        colorValue, STATE_WELL, 0);
                item.setPath(PathParser.createPathFromPathData(pathValue));
                pathlists.add(item);
            }
            mapBean.pathItems = pathlists;
            Log.e("TAG", "getXmlValue: " + pathlists.size());
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("TAG", "getXmlValue: ", e);
        }

        return mapBean;
    }

}
