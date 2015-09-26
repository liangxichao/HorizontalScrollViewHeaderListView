package com.lxc.hslistview;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * @author xichao
 * @date 15/7/19.
 */
public class MyFragmentAdapter extends FragmentPagerAdapter {

    Activity activity;
    ArrayList<Fragment> fs;

    public MyFragmentAdapter(Activity activity, FragmentManager fm) {
        super(fm);
        fs = new ArrayList<Fragment>();

        for (int i = 0; i < 10; i++) {
            fs.add(new MyFragment());
        }
    }


    @Override
    public Fragment getItem(int i) {
        return fs.get(i);
    }

    @Override
    public int getCount() {
        return fs.size();
    }
}
