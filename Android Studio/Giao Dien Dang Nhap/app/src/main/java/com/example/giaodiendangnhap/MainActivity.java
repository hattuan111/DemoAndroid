package com.example.giaodiendangnhap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.giaodiendangnhap.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private EditText txttk;
    private EditText txtmk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txttk = binding.txttk;
        txtmk = binding.txtmk;
        binding.btnDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                //pundle.putString("Username", username)
                Intent i=getIntent();
                Bundle bundle = i.getExtras();
                // sử dụng equals để so sánh
                if(bundle != null){
                    String user = bundle.getString("username");
                    String pass = bundle.getString("pass");
                    boolean u=user.equals(binding.txttk.getText().toString());
                    boolean p=pass.equals(binding.txtmk.getText().toString());
                    if(u&&p){
                        Toast.makeText(MainActivity.this,"Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(MainActivity.this, "Tài khoản hoặc mật khẩu không chính xác", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                */
                String username = txttk.getText().toString().trim();
                String password = txtmk.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }

                database db = new database(MainActivity.this);
                boolean accountExists = db.checkAccount(username, password);

                if (accountExists) {
                    Intent intent = new Intent(MainActivity.this, GiaoDien.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Tài khoản hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                }
            }
        });
        binding.btnDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DangKi.class);
                startActivity(intent);
            }
        });
    }
}