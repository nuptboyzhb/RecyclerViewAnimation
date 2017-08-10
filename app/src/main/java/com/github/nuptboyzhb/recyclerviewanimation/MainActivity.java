package com.github.nuptboyzhb.recyclerviewanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.nuptboyzhb.recyclerviewanimation.grid.StaggeredGridActivity;

/**
 * @version Created by haibozheng on 2017/8/9.
 * @Author Zheng Haibo
 * @Blog github.com/nuptboyzhb
 * @Company Alibaba Group
 * @Description RecyclerViewAnimation
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.list_rv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RecyclerViewActivity.class));
            }
        });

        findViewById(R.id.grid_rv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, StaggeredGridActivity.class));
            }
        });

    }
}