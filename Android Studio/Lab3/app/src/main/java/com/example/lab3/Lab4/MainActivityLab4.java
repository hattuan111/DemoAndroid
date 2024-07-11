package com.example.lab3.Lab4;

import android.os.Bundle;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab3.Adapter.lab4Adapter;
import com.example.lab3.Model.lab4;
import com.example.lab3.Model.menuBai2;
import com.example.lab3.R;

import java.util.ArrayList;

public class MainActivityLab4 extends AppCompatActivity {
    private ArrayList<lab4> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_lab4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        GridView lst = findViewById(R.id.lst);
        list.add(new lab4(R.drawable.cafekem, "Cafe kem", 30000 ));
        list.add(new lab4(R.drawable.duahau, "Nước ép dưa hấu", 25000 ));
        list.add(new lab4(R.drawable.bo, "Sinh tố bơ", 35000));
        list.add(new lab4(R.drawable.nuoccam, "Nước cam ép", 20000));
        list.add(new lab4(R.drawable.tranh, "Nước tranh thanh mát", 20000));
        list.add(new lab4(R.drawable.trasua, "Trà sữa", 25000));

        lab4Adapter adapter = new lab4Adapter(this, list);
        lst.setAdapter(adapter);
    }
}