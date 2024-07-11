package com.example.spinner.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.spinner.Model.abc;
import com.example.spinner.R;

import java.util.ArrayList;

public class abcAdapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<abc> list;

    public abcAdapter(Context context, ArrayList<abc> list) {
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
        // LayoutInflater là một lơ được sử dụng để khởi tạo tệp XML  bố trí vào

        view = inflater.inflate(R.layout.item, viewGroup, false);
        // ánh xạ các dtuong trên layout
        ImageView hinh = view.findViewById(R.id.hinh);
        TextView ten = view.findViewById(R.id.ten);
        // cập nhật dữ liệu
        hinh.setImageResource(list.get(i).getHinh());
        ten.setText(list.get(i).getTen());
        return view;
    }
}
