package com.example.mysmallapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class TradeSeviceFragment2 extends Fragment {

    private TextView tv2;
    public TradeSeviceFragment2() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tradeservice_fragment2,container,false);
        tv2 = view.findViewById(R.id.tv2);
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),YueChe_Activity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
