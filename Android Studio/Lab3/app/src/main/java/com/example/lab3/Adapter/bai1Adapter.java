package com.example.lab3.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab3.Model.bai1;
import com.example.lab3.R;

import java.util.ArrayList;

public class bai1Adapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<bai1> list;

    public bai1Adapter(Context context, ArrayList<bai1> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        // LayoutInflater là một lớp được sử dụng để khởi tạo tệp XML bố trí vào

        if (view == null) {
            view = inflater.inflate(R.layout.item, viewGroup, false);
        }

        // Ánh xạ các đối tượng trên layout
        ImageView hinh = view.findViewById(R.id.hinh);
        TextView ten = view.findViewById(R.id.ten);

        // Cập nhật dữ liệu
        bai1 item = list.get(i);
        hinh.setImageResource(item.getHinh());
        ten.setText(item.getTen());

        return view;
    }
}
