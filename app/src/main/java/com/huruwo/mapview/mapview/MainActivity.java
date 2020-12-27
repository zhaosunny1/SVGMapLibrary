package com.huruwo.mapview.mapview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MapView mapview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapview = (MapView) findViewById(R.id.mapview);


        mapview.setOnZteClickListener(new MapView.OnPathClickListener() {
            @Override
            public void onPathClick(PathItem p) {
                Toast.makeText(getBaseContext(), p.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                final MapBean mapBean = XmlUtil.getXmlValue(MainActivity.this,
                        R.raw.jx_maps, "常州市地图");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("TAG", "run() called");
                        mapview.loadPathItemAndScale(mapBean);
                    }
                });


            }
        }).start();


    }
}
