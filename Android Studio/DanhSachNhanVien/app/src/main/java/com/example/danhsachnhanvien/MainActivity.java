package com.example.danhsachnhanvien;

import android.app.Dialog;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.danhsachnhanvien.Adapter.dsnvAdapter;
import com.example.danhsachnhanvien.Model.DSNV;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lstnv;
    ArrayList<DSNV> listnv = new ArrayList<>();
    dsnvAdapter adapter;
    public static final String TENFILE = "DSNV.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageView img = findViewById(R.id.anh);
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.animation);
        img.startAnimation(animation1);

        // Ánh xạ
        lstnv = findViewById(R.id.listDS);
        Button btnadd = findViewById(R.id.btnAdd);

        // Thêm dữ liệu mẫu
        listnv.add(new DSNV("001", "Hà Anh Tuấn", "Thanh Hóa"));
        listnv.add(new DSNV("002", "Phan Anh Tuấn", "Thanh Hóa"));
        listnv.add(new DSNV("003", "Trần Minh Tuấn", "Hà Nam"));

        // Kiểm tra tồn tại file, thực hiện tạo file và ghi file
        if (!Xfile.kiemtratontai(MainActivity.this, TENFILE)) {
            Xfile.ghifile(MainActivity.this, TENFILE, listnv);
        }

        // Đọc file, gán vào list
        listnv = (ArrayList<DSNV>) Xfile.docfile(MainActivity.this, TENFILE);

        adapter = new dsnvAdapter(this, listnv);
        lstnv.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        // Thêm
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opendialogthem();
            }
        });
    }

    public void opendialogthem() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        View view = getLayoutInflater().inflate(R.layout.item_add, null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();

        // Ánh xạ
        EditText txtmanv = view.findViewById(R.id.id);
        EditText txthoten = view.findViewById(R.id.name);
        EditText txtdiachi = view.findViewById(R.id.address);
        Button btnthem = view.findViewById(R.id.btnThem);
        Button btnhuy = view.findViewById(R.id.btnHuy);

        // Click thêm
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String manv = txtmanv.getText().toString();
                String hoten = txthoten.getText().toString();
                String diachi = txtdiachi.getText().toString();
                listnv.add(new DSNV(manv, hoten, diachi));
                Xfile.ghifile(MainActivity.this, TENFILE, listnv);
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });

        // Click hủy
        btnhuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtmanv.setText("");
                txthoten.setText("");
                txtdiachi.setText("");
            }
        });
    }
}
