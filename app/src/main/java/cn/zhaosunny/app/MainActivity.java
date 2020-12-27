package cn.zhaosunny.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import cn.zhaosunny.svgmaplibrary.SvgMapBean;
import cn.zhaosunny.svgmaplibrary.SvgMapView;
import cn.zhaosunny.svgmaplibrary.SvgPathBean;
import cn.zhaosunny.svgmaplibrary.VectorXmlUtil;

/**
 * @author  zhaosunny on 2020/12/27
 */
public class MainActivity extends AppCompatActivity {

    private SvgMapView mapview;

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
                        mapview.loadPathItemAndScale(mapBean);
                    }
                });


            }
        }).start();
    }
}
