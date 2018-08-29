package com.example.mysmallapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class OrderFragment3 extends Fragment implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener{
    private RadioGroup rg_tab_bar;
    private RadioButton rb_channel;
    private RadioButton rb_message;
    private ViewPager vpager;

    private OrderFragmentPagerAdapter mAdapter;
    public OrderFragment3() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.order_fragment3_layout,container,false);
        mAdapter = new OrderFragmentPagerAdapter(getChildFragmentManager());
        bindViews(view);
        rb_channel.setChecked(true);
        return view;
    }


    private void bindViews(View view) {
        rg_tab_bar = view.findViewById(R.id.rg_tab_bar);
        rb_channel = view.findViewById(R.id.rb_channel);
        rb_message = view.findViewById(R.id.rb_message);
        rg_tab_bar.setOnCheckedChangeListener(this);

        vpager =  view.findViewById(R.id.viewpager);
        vpager.setAdapter(mAdapter);
        vpager.setCurrentItem(0);
        vpager.addOnPageChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_channel:
                vpager.setCurrentItem(0);
                break;
            case R.id.rb_message:
                vpager.setCurrentItem(1);
                break;
        }
    }

    //重写ViewPager页面切换的处理方法
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
        if (state == 2) {
            switch (vpager.getCurrentItem()) {
                case 0:
                    rb_channel.setChecked(true);
                    break;
                case 1:
                    rb_message.setChecked(true);
                    break;
            }
        }
    }
}
