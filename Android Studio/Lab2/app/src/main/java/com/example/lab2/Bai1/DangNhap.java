package com.example.lab2.Bai1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab2.R;

public class DangNhap extends AppCompatActivity {
    private Button dk, dn;
    private EditText tk, mk;
    private String taikhoan, matkhau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dang_nhap);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dk = findViewById(R.id.btnDK);
        dn = findViewById(R.id.btnDN);
        tk = findViewById(R.id.txttk);
        mk = findViewById(R.id.txtmk);

        dk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangNhap.this, DangKy.class);
                startActivity(intent);
            }
        });

        dn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taikhoan = tk.getText().toString().trim();
                matkhau = mk.getText().toString().trim();

                if (taikhoan.isEmpty() || matkhau.isEmpty()) {
                    Toast.makeText(DangNhap.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent i = getIntent();
                Bundle bundle = i.getExtras();

                if (bundle != null) {
                    String user = bundle.getString("Username"); // Sửa khóa ở đây
                    String pass = bundle.getString("Pass");     // Sửa khóa ở đây

                    if (user != null && pass != null) {
                        boolean u = user.equals(taikhoan);
                        boolean p = pass.equals(matkhau);

                        if (u && p) {
                            Intent intent = new Intent(DangNhap.this, GiaoDien.class);
                            startActivity(intent);
                            Toast.makeText(DangNhap.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(DangNhap.this, "Tài khoản hoặc mật khẩu không chính xác", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(DangNhap.this, "Không nhận được thông tin đăng ký", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(DangNhap.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
