package com.example.mysmallapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 曾道喜 on 2018/7/5.
 */

public class OrderUnCompleteFragment extends Fragment {

    public OrderUnCompleteFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.order_uncomplete_fragment,container,false);

        return view;
    }
}
