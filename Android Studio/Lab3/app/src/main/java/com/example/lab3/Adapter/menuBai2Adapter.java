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
import com.example.lab3.Model.menuBai2;
import com.example.lab3.R;

import java.util.ArrayList;

public class menuBai2Adapter extends BaseAdapter {
    private final ArrayList<menuBai2> list;
    private final Context context;

    public menuBai2Adapter(ArrayList<menuBai2> list, Context context) {
        this.list = list;
        this.context = context;
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
            view = inflater.inflate(R.layout.item_bai2, viewGroup, false);
        }

        // Ánh xạ các đối tượng trên layout
        ImageView hinh = view.findViewById(R.id.anh);
        TextView ten = view.findViewById(R.id.name);
        TextView gia = view.findViewById(R.id.price);

        // Cập nhật dữ liệu
        menuBai2 item = list.get(i);
        hinh.setImageResource(item.getHinh());
        ten.setText(item.getTen());
        gia.setText(item.getGia());
        return view;
    }
}
