package com.example.myapplication1;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Handler;
import android.view.View;

public class ColorChange {
    private static Handler handler;
    private static Runnable runnable;
    private static final int[] colors = {
            Color.parseColor("#F5F5DC"),   // 米色
            Color.parseColor("#FFFACD"),   // 浅黄色
            Color.parseColor("#E6E6FA"),   // 淡紫色
            Color.parseColor("#FFB6C1"),   // 淡红色
            Color.parseColor("#FFF0F5"),   // 粉色
            Color.parseColor("#F0E68C")    // 淡黄色
    };
    private static int currentColorIndex = 0; // 当前颜色索引
    @SuppressLint("StaticFieldLeak")
    private static View backgroundView; // 背景视图

    public static void startColorAnimation(View view) {
        backgroundView = view;
        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                // 获取当前颜色和下一个颜色
                int colorFrom = colors[currentColorIndex];
                int nextColorIndex = (currentColorIndex + 1) % colors.length; // 循环索引
                int colorTo = colors[nextColorIndex];

                // 创建一个渐变动画
                ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
                colorAnimation.setDuration(3000); // 持续时间3秒
                colorAnimation.addUpdateListener(animator -> {
                    // 更新布局背景颜色
                    backgroundView.setBackgroundColor((int) animator.getAnimatedValue());
                });

                // 开始动画
                colorAnimation.start();

                // 更新当前颜色索引
                currentColorIndex = nextColorIndex;

                // 每隔3秒执行一次
                handler.postDelayed(this, 3000);
            }
        };

        // 开始颜色变化
        handler.post(runnable);
    }

    public static void stopColorAnimation() {
        if (handler != null && runnable != null) {
            handler.removeCallbacks(runnable);
        }
    }
}
