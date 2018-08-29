package com.example.mysmallapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

/**
 * Created by 曾道喜 on 2018/7/5.
 */


public class OrderFragmentPagerAdapter extends FragmentPagerAdapter {

    private OrderCompleteFragment orderCompleteFragment;
    private OrderUnCompleteFragment orderUnCompleteFragment;

    public OrderFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        orderCompleteFragment = new OrderCompleteFragment();
        orderUnCompleteFragment = new OrderUnCompleteFragment();
    }


    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Object instantiateItem(ViewGroup vg, int position) {
        return super.instantiateItem(vg, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        System.out.println("position Destory" + position);
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = orderCompleteFragment;
                break;
            case 1:
                fragment = orderUnCompleteFragment;
                break;
        }
        return fragment;
    }
}


