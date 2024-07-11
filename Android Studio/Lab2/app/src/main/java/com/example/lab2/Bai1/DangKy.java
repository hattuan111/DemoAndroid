package com.example.lab2.Bai1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab2.R;

public class DangKy extends AppCompatActivity {
    private EditText tk, mk, mk2, sdt, email;
    private Button dk;
    private RadioButton rdonam, rdonu;
    private String taikhoan, matkhau, matkhau2, sodienthoai, emaill, gioitinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dang_ky);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tk = findViewById(R.id.txttk);
        mk = findViewById(R.id.txtmk);
        mk2 = findViewById(R.id.txtmk2);
        sdt = findViewById(R.id.txtsdt);
        email = findViewById(R.id.txtemail);
        dk = findViewById(R.id.btnDK);
        rdonam = findViewById(R.id.rdobnam);
        rdonu = findViewById(R.id.rdobnu);

        dk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taikhoan = tk.getText().toString().trim();
                matkhau = mk.getText().toString().trim();
                matkhau2 = mk2.getText().toString().trim();
                sodienthoai = sdt.getText().toString().trim();
                emaill = email.getText().toString().trim();

                if (taikhoan.isEmpty() || matkhau.isEmpty() || matkhau2.isEmpty() || sodienthoai.isEmpty() || emaill.isEmpty()) {
                    Toast.makeText(DangKy.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                gioitinh = rdonam.isChecked() ? "Nam" : "Nữ";
                if (!rdonam.isChecked() && !rdonu.isChecked()) {
                    Toast.makeText(DangKy.this, "Vui lòng chọn giới tính", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (matkhau.equals(matkhau2)) {
                    Toast.makeText(DangKy.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                    // gửi dữ liệu đi
                    Intent intent = new Intent(DangKy.this, DangNhap.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("Username", taikhoan);
                    bundle.putString("Pass", matkhau);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else {
                    Toast.makeText(DangKy.this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
