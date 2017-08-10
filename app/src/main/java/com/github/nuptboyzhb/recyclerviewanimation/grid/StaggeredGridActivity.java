package com.github.nuptboyzhb.recyclerviewanimation.grid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.GridLayoutAnimationController;
import android.view.animation.LayoutAnimationController;

import com.github.nuptboyzhb.animations.MyLayoutAnimationHelper;
import com.github.nuptboyzhb.recyclerviewanimation.grid.StaggeredGridAdapter.Items;

import com.github.nuptboyzhb.recyclerviewanimation.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @version Created by haibozheng on 2017/8/9.
 * @Author Zheng Haibo
 * @Blog github.com/nuptboyzhb
 * @Company Alibaba Group
 * @Description RecyclerViewAnimation
 */

public class StaggeredGridActivity extends AppCompatActivity {

    private StaggeredGridRecyclerView mRecyclerView;
    private StaggeredGridAdapter mStaggeredGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_grid);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (StaggeredGridRecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mStaggeredGridAdapter = new StaggeredGridAdapter();
        mStaggeredGridAdapter.setDataSet(mockData());
        mRecyclerView.setAdapter(mStaggeredGridAdapter);
        LayoutAnimationController controller = MyLayoutAnimationHelper.makeLayoutAnimationController();
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.root_view);
        viewGroup.setLayoutAnimation(controller);
        viewGroup.scheduleLayoutAnimation();
    }

    private List<StaggeredGridAdapter.Items> mockData() {
        List<StaggeredGridAdapter.Items> dataList = new ArrayList<>();
        dataList.add(new Items("flower", R.drawable.image_0002));
        dataList.add(new Items("flower", R.drawable.image_0003));
        dataList.add(new Items("flower", R.drawable.image_0838));
        dataList.add(new Items("flower", R.drawable.image_1107));
        dataList.add(new Items("flower", R.drawable.image_0005));
        dataList.add(new Items("flower", R.drawable.image_1118));
        dataList.add(new Items("flower", R.drawable.image_0007));
        dataList.add(new Items("flower", R.drawable.image_1150));
        dataList.add(new Items("flower", R.drawable.image_0009));
        dataList.add(new Items("flower", R.drawable.image_1281));
        dataList.add(new Items("flower", R.drawable.image_0011));
        dataList.add(new Items("flower", R.drawable.image_1293));
        dataList.add(new Items("flower", R.drawable.image_1342));
        dataList.add(new Items("flower", R.drawable.image_1351));
        dataList.add(new Items("flower", R.drawable.image_0015));
        for (int i = 0; i < dataList.size(); i++) {
            Items items = dataList.get(i);
            items.name = String.format("flower %s", i);
        }
        return dataList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_left) {
            playLayoutAnimation(MyLayoutAnimationHelper.getAnimationSetFromLeft());
        } else if (id == R.id.action_right) {
            playLayoutAnimation(MyLayoutAnimationHelper.getAnimationSetFromRight());
        } else if (id == R.id.action_bottom) {
            playLayoutAnimation(MyLayoutAnimationHelper.getAnimationSetFromBottom());
        } else if (id == R.id.action_top) {
            playLayoutAnimation(MyLayoutAnimationHelper.getAnimationSetFromTop(), true);
        } else if (id == R.id.action_scale_enlarge) {
            playLayoutAnimation(MyLayoutAnimationHelper.getAnimationSetScaleBig());
        } else if (id == R.id.action_scale_narrow) {
            playLayoutAnimation(MyLayoutAnimationHelper.getAnimationSetScaleNarrow());
        } else if (id == R.id.action_alpha) {
            playLayoutAnimation(MyLayoutAnimationHelper.getAnimationSetAlpha());
        } else if (id == R.id.action_rotation) {
            playLayoutAnimation(MyLayoutAnimationHelper.getAnimationSetRotation());
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 播放动画
     *
     * @param animation
     * @param isReverse
     */
    public void playLayoutAnimation(Animation animation, boolean isReverse) {
        GridLayoutAnimationController controller = new GridLayoutAnimationController(animation);
        controller.setColumnDelay(0.2f);
        controller.setRowDelay(0.3f);
        controller.setOrder(isReverse ? LayoutAnimationController.ORDER_REVERSE : LayoutAnimationController.ORDER_NORMAL);

        mRecyclerView.setLayoutAnimatigit on(controller);
        mRecyclerView.getAdapter().notifyDataSetChanged();
        mRecyclerView.scheduleLayoutAnimation();
    }


    public void playLayoutAnimation(Animation animation) {
        playLayoutAnimation(animation, false);
    }


}
