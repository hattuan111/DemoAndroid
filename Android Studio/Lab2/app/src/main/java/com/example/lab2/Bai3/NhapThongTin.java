package com.example.lab2.Bai3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab2.R;

public class NhapThongTin extends AppCompatActivity {
    private EditText txtMa, txtTen;
    private RadioButton rdoNam, rdoNu;
    private CheckBox checkbox1, checkbox2, checkbox3, checkbox4, checkbox5, checkbox6;
    private Button btnHienThi, btnThoat;
    private TextView tvThongTinGV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nhap_thong_tin);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtMa = findViewById(R.id.txtMa);
        txtTen = findViewById(R.id.txtTen);
        rdoNam = findViewById(R.id.rdoNam);
        rdoNu = findViewById(R.id.rdoNu);
        checkbox1 = findViewById(R.id.checkbox1);
        checkbox2 = findViewById(R.id.checkbox2);
        checkbox3 = findViewById(R.id.checkbox3);
        checkbox4 = findViewById(R.id.checkbox4);
        checkbox5 = findViewById(R.id.checkbox5);
        checkbox6 = findViewById(R.id.checkbox6);
        btnHienThi = findViewById(R.id.btnHienThi);
        btnThoat = findViewById(R.id.btnThoat);
        tvThongTinGV = findViewById(R.id.tvThongTinGV);

        btnHienThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lấy thông tin từ các EditText
                String maGV = txtMa.getText().toString().trim();
                String tenGV = txtTen.getText().toString().trim();

                // Xử lý giới tính
                String gioiTinh = "";
                if (rdoNam.isChecked()) {
                    gioiTinh = "Nam";
                } else if (rdoNu.isChecked()) {
                    gioiTinh = "Nữ";
                }

                // Xử lý sở thích
                StringBuilder soThich = new StringBuilder();
                if (checkbox1.isChecked()) {
                    soThich.append("Nghe nhạc, ");
                }
                if (checkbox2.isChecked()) {
                    soThich.append("Xem phim, ");
                }
                if (checkbox3.isChecked()) {
                    soThich.append("Thể thao, ");
                }
                if (checkbox4.isChecked()) {
                    soThich.append("Du lịch, ");
                }
                if (checkbox5.isChecked()) {
                    soThich.append("Mua sắm, ");
                }
                if (checkbox6.isChecked()) {
                    soThich.append("Đọc sách, ");
                }


                // Hiển thị thông tin giáo viên trên TextView
                String thongTinGV = "Mã GV: " + maGV + "\n"
                        + "Tên GV: " + tenGV + "\n"
                        + "Giới tính: " + gioiTinh + "\n"
                        + "Sở thích: " + soThich.toString();

                tvThongTinGV.setText(thongTinGV);
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // Đóng activity hiện tại
            }
        });
    }
}