package com.example.danhsachnhanvien.Adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.example.danhsachnhanvien.MainActivity;
import com.example.danhsachnhanvien.Model.DSNV;
import com.example.danhsachnhanvien.R;
import com.example.danhsachnhanvien.Xfile;

import java.util.ArrayList;

public class dsnvAdapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<DSNV> list;

    public dsnvAdapter(Context context, ArrayList<DSNV> list) {
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
        view = inflater.inflate(R.layout.item_listview, viewGroup, false);

        // ánh xạ
        TextView txtma = view.findViewById(R.id.txtMa);
        TextView txtht = view.findViewById(R.id.txtTen);
        TextView txtdc = view.findViewById(R.id.txtDC);
        Button btnupdate = view.findViewById(R.id.btnUpdate);
        Button btnxoa = view.findViewById(R.id.btnDelete);

        // gán dữ liệu
        txtma.setText(list.get(i).getMa());
        txtht.setText(list.get(i).getTen());
        txtdc.setText(list.get(i).getDc());

        // cách 1: ấn giữ lâu vào dòng thì xóa dòng
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                list.remove(i);
                notifyDataSetChanged();
                Toast.makeText(context, "đã xóa", Toast.LENGTH_SHORT).show();
                Xfile.ghifile(context, MainActivity.TENFILE, list); // ghi file
                return false;
            }
        });

        // cách 2: click vào nút button XÓA
        btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.remove(i);
                notifyDataSetChanged();
                Toast.makeText(context, "đã xóa", Toast.LENGTH_SHORT).show();
                Xfile.ghifile(context, MainActivity.TENFILE, list); // ghi file
            }
        });

        //update
        DSNV nv = list.get(i);//truy suất đến đối tượng update
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opendialog(nv);
            }
        });
        return view;
    }
    public void opendialog(DSNV nv) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_update, null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();
        //anh xa
        EditText txtmanvs = view.findViewById(R.id.id);
        EditText txthotens = view.findViewById(R.id.name);
        EditText txtdiachis = view.findViewById(R.id.address);
        Button btnedit = view.findViewById(R.id.btnCapNhat);
        //gán du lieu lên các textview
        txtmanvs.setText(nv.getMa());
        txthotens.setText(nv.getTen());
        txtdiachis.setText(nv.getDc());
        //click update
        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nv.setMa(txtmanvs.getText().toString());
                nv.setTen(txthotens.getText().toString());
                nv.setDc(txtdiachis.getText().toString());
                dialog.dismiss();
                Xfile.ghifile(context, MainActivity.TENFILE, list);;//ghi vào file
                notifyDataSetChanged();
            }
        });
    }
}
