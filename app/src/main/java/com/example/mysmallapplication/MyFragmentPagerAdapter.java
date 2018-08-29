package com.example.mysmallapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private SelectFragment1 selectFragment1;
    private TradeSeviceFragment2 tradeSeviceFragment2;
    private OrderFragment3 orderFragment3;
    private MyFragment4 myFragment4;


    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        selectFragment1 = new SelectFragment1();
        tradeSeviceFragment2 = new TradeSeviceFragment2();
        orderFragment3 = new OrderFragment3();
        myFragment4 = new MyFragment4();
    }


    @Override
    public int getCount() {
        return 4;
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
                fragment = selectFragment1;
                break;
            case 1:
                fragment = tradeSeviceFragment2;
                break;
            case 2:
                fragment = orderFragment3;
                break;
            case 3:
                fragment = myFragment4;
                break;
        }
        return fragment;
    }
}

