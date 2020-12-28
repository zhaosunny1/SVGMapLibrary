package cn.zhaosunny.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import cn.zhaosunny.svgmaplibrary.SvgMapBean;
import cn.zhaosunny.svgmaplibrary.SvgMapView;
import cn.zhaosunny.svgmaplibrary.SvgPathBean;
import cn.zhaosunny.svgmaplibrary.VectorXmlUtil;

/**
 * @author zhaosunny on 2020/12/27
 */
public class MainActivity extends AppCompatActivity {

    private SvgMapView mapview;
    private SvgMapBean svgMapBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapview = (SvgMapView) findViewById(R.id.mapview);


        mapview.setOnAreaClickListener(new SvgMapView.OnPathClickListener() {
            @Override
            public void onPathClick(SvgPathBean p) {
                Toast.makeText(getBaseContext(), p.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                final SvgMapBean mapBean = VectorXmlUtil
                        .getXmlValue(MainActivity.this,
                                R.raw.changezhou_maps, "常州市地图");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        svgMapBean = mapBean;
                        mapview.loadPathItem(mapBean);
                    }
                });


            }
        }).start();
        View colorButton = findViewById(R.id.btn_changecolor);
        colorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapview.pathItems != null && mapview.pathItems.size() > 0) {
                    mapview.setTextColor("#ff00ff");
                    mapview.pathItems.get(0).setColor("#00ff00");
                    mapview.notifyDataSetChanged();
                }
            }
        });
    }
}
