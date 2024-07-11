package com.example.giaodiendangnhap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.giaodiendangnhap.databinding.ActivityDangKiBinding;

public class DangKi extends AppCompatActivity {
    private ActivityDangKiBinding binding;
    String username;
    String password;
    String confirmPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dang_ki);
        binding = ActivityDangKiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        binding.btnDk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = binding.username.getText().toString().trim();
                password = binding.password.getText().toString().trim();
                confirmPassword = binding.password2.getText().toString().trim();

                // Kiểm tra các trường không được bỏ trống
                if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(DangKi.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Kiểm tra mật khẩu và xác nhận mật khẩu khớp
                if (password.equals(confirmPassword)) {
                    // Tạo đối tượng database và thêm account mới
                    database db = new database(DangKi.this);
                    db.addAccount(username, password);
                    Toast.makeText(DangKi.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                    // gửi dữ liệu đi
//                    Intent intent = new Intent(DangKi.this, MainActivity.class);
//                    Bundle bundle = new Bundle();
//                    bundle.putString("Username", username);
//                    bundle.putString("Pass", password);
//                    intent.putExtras(bundle);
//                    startActivity(intent);
                }else {
                    Toast.makeText(DangKi.this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }

}