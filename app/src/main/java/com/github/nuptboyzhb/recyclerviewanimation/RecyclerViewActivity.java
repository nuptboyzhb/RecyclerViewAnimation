package com.github.nuptboyzhb.recyclerviewanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LayoutAnimationController;

import com.github.nuptboyzhb.animations.MyLayoutAnimationHelper;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new DemoRecyclerViewAdapter());
        LayoutAnimationController controller = MyLayoutAnimationHelper.makeLayoutAnimationController();
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.root_view);
        viewGroup.setLayoutAnimation(controller);
        viewGroup.scheduleLayoutAnimation();
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
     * 播放RecyclerView动画
     *
     * @param animation
     * @param isReverse
     */
    public void playLayoutAnimation(Animation animation, boolean isReverse) {
        LayoutAnimationController controller = new LayoutAnimationController(animation);
        controller.setDelay(0.1f);
        controller.setOrder(isReverse ? LayoutAnimationController.ORDER_REVERSE : LayoutAnimationController.ORDER_NORMAL);

        mRecyclerView.setLayoutAnimation(controller);
        mRecyclerView.getAdapter().notifyDataSetChanged();
        mRecyclerView.scheduleLayoutAnimation();
    }

    public void playLayoutAnimation(Animation animation) {
        playLayoutAnimation(animation, false);
    }

}
