package com.example.mysmallapplication;

/**
 * Created by 曾道喜 on 2018/8/31.
 */

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;


public class SelectPeoAdapter extends BaseAdapter {

    private Context context;
    private List<HashMap<String, Object>> list;
    private LayoutInflater layoutInflater;
    private TextView tv,tvnum,tvpiao;
    private CheckBox cb;

    public SelectPeoAdapter(Context context, List<HashMap<String, Object>> list) {
        this.context = context;
        this.list = list;//list中checkbox状态为false
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.layout_selectpeople_listview_item, null);
            ViewC viewC = new ViewC();
            cb = convertView.findViewById(R.id.cb);
            tv = convertView.findViewById(R.id.item_name1);
            tvnum = convertView.findViewById(R.id.item_num);
            tvpiao = convertView.findViewById(R.id.item_piao);

            viewC.cb = cb;
            viewC.tv = tv;
            viewC.tvnum = tvnum;
            viewC.tvpiao = tvpiao;
            convertView.setTag(viewC);//用来存储一些view的数据
        } else {
            ViewC viewCache = (ViewC) convertView.getTag();
            cb = viewCache.cb;
            tv = viewCache.tv;
            tvnum = viewCache.tvnum;
            tvpiao = viewCache.tvpiao;
        }

        tv.setText(list.get(position).get("name") + "");
        tvnum.setText(list.get(position).get("number") + "");
        tvpiao.setText(list.get(position).get("piao") + "");
        cb.setChecked((Boolean) list.get(position).get("boolean"));
        return convertView;
    }

    public class ViewC {
        CheckBox cb;
        TextView tv;
        TextView tvnum;
        TextView tvpiao;
    }

    public TextView getTv() {
        return tv;
    }

    public TextView getTvnum() {
        return tvnum;
    }

    public TextView getTvpiao() {
        return tvpiao;
    }

    public CheckBox getCb() {

        return cb;
    }
}


