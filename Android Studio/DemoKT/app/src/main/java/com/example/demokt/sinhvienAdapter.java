package com.example.demokt;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class sinhvienAdapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<SinhVien> list;

    public sinhvienAdapter(Context context, ArrayList<SinhVien> list) {
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
        view = inflater.inflate(R.layout.list_dsnv, viewGroup, false);
        //ánh xạ
        TextView txtma = view.findViewById(R.id.txtma);
        TextView txtht = view.findViewById(R.id.txtht);
        TextView txtdc = view.findViewById(R.id.txtdc);
        TextView txtdiem = view.findViewById(R.id.txtdiem);
        //gan du lieu
        txtma.setText(list.get(i).getMasv());
        txtht.setText(list.get(i).getHoten());
        txtdc.setText(list.get(i).getQuequan());
        txtdiem.setText(list.get(i).getDiem());
        // giữ xóa
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                list.remove(i);
                notifyDataSetChanged();
                Toast.makeText(context, "đã xóa", Toast.LENGTH_SHORT).show();
                // Xfile.ghifile(context, "nv.txt", list);//ghi file
                File.ghiFile(context, Bai3.TENFILE, list);//ghi file
                return false;
            }
        });
        return view;
    }
}
