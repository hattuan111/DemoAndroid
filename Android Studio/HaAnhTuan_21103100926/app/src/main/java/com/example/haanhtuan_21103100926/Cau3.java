package com.example.haanhtuan_21103100926;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Cau3 extends AppCompatActivity {
    ListView listsv;
    ArrayList<sinhvien> list_sv = new ArrayList<>();
    sinhvienAdapter adapter;
    public static final String TENFILE = "sinhvien.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cau3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listsv = findViewById(R.id.dssv);
        list_sv.add(new sinhvien("001", "Hà Anh Tuấn", "Thanh Hóa","8"));
        list_sv.add(new sinhvien("002", "Nguyễn Minh Trung", "Hà Nội","9"));
        list_sv.add(new sinhvien("003", "Trần Thùy Linh", "Bắc Ninh", "8"));
        list_sv.add(new sinhvien("004", "Trịnh Huy Tùng", "Nam Định", "9"));
        list_sv.add(new sinhvien("005", "Vũ Lan Anh", "Nghệ An", "8"));
        list_sv.add(new sinhvien("006", "Nguyễn Đình Sơn", "Vĩnh Phúc", "9"));
        //kiem tra tồn tại file, thực hiện tạo file và ghi file
        if(!File.kiemtratontai(Cau3.this, TENFILE)){
            File.ghiFile(Cau3.this, TENFILE, list_sv);
        }
        //đọc file, gán la list
        list_sv = (ArrayList<sinhvien>) File.docFile(Cau3.this, TENFILE);

        adapter = new sinhvienAdapter(this, list_sv);
        listsv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}