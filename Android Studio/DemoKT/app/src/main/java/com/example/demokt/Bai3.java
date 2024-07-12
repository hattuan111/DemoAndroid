package com.example.demokt;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Bai3 extends AppCompatActivity {
    ListView listsv;
    ArrayList<SinhVien> list_sv = new ArrayList<>();
    sinhvienAdapter adapter;
    public static final String TENFILE = "SinhVien.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // ánh xạ
        listsv =findViewById(R.id.lstnv);

        list_sv.add(new SinhVien("h", "dsgs", "eyd", "6"));
        list_sv.add(new SinhVien("h", "gsg", "dhd", "9"));
        File.ghiFile(Bai3.this, TENFILE, list_sv);
        //kiem tra tồn tại file, thực hiện tạo file và ghi file
        if(!File.kiemtratontai(Bai3.this, TENFILE)){
            File.ghiFile(Bai3.this, TENFILE, list_sv);
        }
        //đọc file, gán la list
        list_sv = (ArrayList<SinhVien>) File.docFile(Bai3.this, TENFILE);

        adapter = new sinhvienAdapter(this, list_sv);
        listsv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}