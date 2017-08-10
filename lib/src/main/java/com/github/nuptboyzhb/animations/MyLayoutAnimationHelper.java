package com.github.nuptboyzhb.animations;

import android.support.v7.widget.RecyclerView;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LayoutAnimationController;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import static android.view.animation.Animation.RELATIVE_TO_SELF;


/**
 * @version Created by haibozheng on 2016/12/7.
 * @Author Zheng Haibo
 * @Blog github.com/nuptboyzhb
 * @Company Alibaba Group
 * @Description MyLayoutAnimationHelper
 */
public class MyLayoutAnimationHelper {

    public static void applyAnimation(RecyclerView recyclerView) {
        LayoutAnimationController controller = new LayoutAnimationController(getAnimationSetFromLeft());
        controller.setDelay(0.1f);
        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);

        recyclerView.setLayoutAnimation(controller);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }

    public static LayoutAnimationController makeLayoutAnimationController() {
        LayoutAnimationController controller = new LayoutAnimationController(getAnimationSetFromRight());
        controller.setDelay(0.1f);
        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
        return controller;
    }

    /**
     * 从左侧进入，并带有弹性的动画
     *
     * @return
     */
    public static AnimationSet getAnimationSetFromLeft() {
        AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation translateX1 = new TranslateAnimation(RELATIVE_TO_SELF, -1.0f, RELATIVE_TO_SELF, 0.1f,
                RELATIVE_TO_SELF, 0, RELATIVE_TO_SELF, 0);
        translateX1.setDuration(300);
        translateX1.setInterpolator(new DecelerateInterpolator());
        translateX1.setStartOffset(0);

        TranslateAnimation translateX2 = new TranslateAnimation(RELATIVE_TO_SELF, 0.1f, RELATIVE_TO_SELF, -0.1f,
                RELATIVE_TO_SELF, 0, RELATIVE_TO_SELF, 0);
        translateX2.setStartOffset(300);
        translateX2.setInterpolator(new DecelerateInterpolator());
        translateX2.setDuration(50);

        TranslateAnimation translateX3 = new TranslateAnimation(RELATIVE_TO_SELF, -0.1f, RELATIVE_TO_SELF, 0f,
                RELATIVE_TO_SELF, 0, RELATIVE_TO_SELF, 0);
        translateX3.setStartOffset(350);
        translateX3.setInterpolator(new DecelerateInterpolator());
        translateX3.setDuration(50);

        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
        alphaAnimation.setDuration(400);
        alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());


        animationSet.addAnimation(translateX1);
        animationSet.addAnimation(translateX2);
        animationSet.addAnimation(translateX3);
        //animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(400);

        return animationSet;
    }

    /**
     * 从右侧进入，并带有弹性的动画
     *
     * @return
     */
    public static AnimationSet getAnimationSetFromRight() {
        AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation translateX1 = new TranslateAnimation(RELATIVE_TO_SELF, 1.0f, RELATIVE_TO_SELF, -0.1f,
                RELATIVE_TO_SELF, 0, RELATIVE_TO_SELF, 0);
        translateX1.setDuration(300);
        translateX1.setInterpolator(new DecelerateInterpolator());
        translateX1.setStartOffset(0);

        TranslateAnimation translateX2 = new TranslateAnimation(RELATIVE_TO_SELF, -0.1f, RELATIVE_TO_SELF, 0.1f,
                RELATIVE_TO_SELF, 0, RELATIVE_TO_SELF, 0);
        translateX2.setStartOffset(300);
        translateX2.setInterpolator(new DecelerateInterpolator());
        translateX2.setDuration(50);

        TranslateAnimation translateX3 = new TranslateAnimation(RELATIVE_TO_SELF, 0.1f, RELATIVE_TO_SELF, 0f,
                RELATIVE_TO_SELF, 0, RELATIVE_TO_SELF, 0);
        translateX3.setStartOffset(350);
        translateX3.setInterpolator(new DecelerateInterpolator());
        translateX3.setDuration(50);

        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
        alphaAnimation.setDuration(400);
        alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());


        animationSet.addAnimation(translateX1);
        animationSet.addAnimation(translateX2);
        animationSet.addAnimation(translateX3);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(400);

        return animationSet;
    }

    /**
     * 从底部进入
     *
     * @return
     */
    public static AnimationSet getAnimationSetFromBottom() {
        AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation translateX1 = new TranslateAnimation(RELATIVE_TO_SELF, 0, RELATIVE_TO_SELF, 0,
                RELATIVE_TO_SELF, 2.5f, RELATIVE_TO_SELF, 0);
        translateX1.setDuration(400);
        translateX1.setInterpolator(new DecelerateInterpolator());
        translateX1.setStartOffset(0);

        animationSet.addAnimation(translateX1);
        animationSet.setDuration(400);

        return animationSet;
    }

    /**
     * 从顶部进入
     *
     * @return
     */
    public static AnimationSet getAnimationSetFromTop() {
        AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation translateX1 = new TranslateAnimation(RELATIVE_TO_SELF, 0, RELATIVE_TO_SELF, 0,
                RELATIVE_TO_SELF, -2.5f, RELATIVE_TO_SELF, 0);
        translateX1.setDuration(400);
        translateX1.setInterpolator(new DecelerateInterpolator());
        translateX1.setStartOffset(0);

        animationSet.addAnimation(translateX1);
        animationSet.setDuration(400);

        return animationSet;
    }

    /**
     * 放大动画
     *
     * @return
     */
    public static AnimationSet getAnimationSetScaleBig() {
        AnimationSet animationSet = new AnimationSet(true);

        ScaleAnimation scaleAnimation = new ScaleAnimation(0.1f, 1.0f, 0.1f, 1.0f, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setInterpolator(new DecelerateInterpolator());
        scaleAnimation.setDuration(400);


        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(400);

        return animationSet;
    }

    /**
     * 缩小动画
     *
     * @return
     */
    public static AnimationSet getAnimationSetScaleNarrow() {
        AnimationSet animationSet = new AnimationSet(true);

        ScaleAnimation scaleAnimation = new ScaleAnimation(2.1f, 1.0f, 2.1f, 1.0f, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setInterpolator(new DecelerateInterpolator());
        scaleAnimation.setDuration(400);

        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(400);

        return animationSet;
    }


    /**
     * 透明度动画
     *
     * @return
     */
    public static AnimationSet getAnimationSetAlpha() {
        AnimationSet animationSet = new AnimationSet(true);

        AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        alphaAnimation.setDuration(400);

        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(400);

        return animationSet;
    }


    /**
     * 旋转动画
     *
     * @return
     */
    public static AnimationSet getAnimationSetRotation() {
        AnimationSet animationSet = new AnimationSet(true);

        RotateAnimation rotateAnimation = new RotateAnimation(30, 0, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(400);
        rotateAnimation.setInterpolator(new DecelerateInterpolator());

        animationSet.addAnimation(rotateAnimation);
        animationSet.setDuration(400);

        return animationSet;
    }


}
