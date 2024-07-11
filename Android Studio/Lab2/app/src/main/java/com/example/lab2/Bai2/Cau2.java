package com.example.lab2.Bai2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab2.R;

public class Cau2 extends AppCompatActivity {
    private Button btnOption1, btnOption2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cau2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnOption1 = findViewById(R.id.btn1); // Ánh xạ cho btnOption1
        btnOption2 = findViewById(R.id.btn2); // Ánh xạ cho btnOption2

        btnOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Cau2.this, "Xin chúc mừng, sang câu tiếp theo nào", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Cau2.this, Cau3.class);
                startActivity(intent);
            }
        });

        btnOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Cau2.this, "Sai rồi, thử lại nào", Toast.LENGTH_SHORT).show();
                // Xử lý khi người dùng chọn sai ở đây
            }
        });
    }
}