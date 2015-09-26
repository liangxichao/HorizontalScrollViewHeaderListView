package com.lxc.hslistview;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @author liangxichao
 * @date 15/7/19.
 */
public class MyActivity extends FragmentActivity implements ViewPager.OnPageChangeListener {
    HorizontalScrollView scrollView;
    LinearLayout linearLayout;
    Activity activity = this;
    ViewPager pager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initViews();
    }

    private void initViews() {
        pager = findView(R.id.pager);
        scrollView = findView(R.id.scrollView);
        linearLayout = findView(R.id.view_group);
        initHScrollViewLayout(linearLayout);
        pager.setOnPageChangeListener(this);
        pager.setAdapter(new MyFragmentAdapter(activity, getSupportFragmentManager()));
    }

    public <V extends View> V findView(int resId) {
        return (V) findViewById(resId);
    }

    private void initHScrollViewLayout(ViewGroup parent) {
        for (int i = 0; i < 15; i++) {
            TextView textView = new TextView(this);
            textView.setText("tab" + i);
            textView.setTextColor(Color.parseColor("#000000"));
            textView.setTextSize(20);
            textView.setGravity(Gravity.CENTER);
            textView.setSingleLine();
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int i = linearLayout.indexOfChild(view);
                    pager.setCurrentItem(i, true);
                }
            });
            int color1 = Color.parseColor("#ff0000");
            int color2 = Color.parseColor("#00ff00");
            if (i > 0) {
                textView.setBackgroundColor((i % 2) == 0 ? color1 : color2);
            } else {
                textView.setBackgroundColor(color1);
            }

            int with = 170;
            int height = 80;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(with, height);
            textView.setLayoutParams(params);

            parent.addView(textView);
        }

    }

    @Override
    public void onPageScrolled(int i, float v, int i2) {

    }

    @Override
    public void onPageSelected(int i) {
        View view = linearLayout.getChildAt(i);
        int scrollPos = view.getLeft() - (scrollView.getWidth() - view.getWidth()) / 2;
        scrollView.smoothScrollTo(scrollPos, 0);
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
