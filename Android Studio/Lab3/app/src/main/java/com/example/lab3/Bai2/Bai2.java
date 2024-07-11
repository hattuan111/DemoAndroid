package com.example.lab3.Bai2;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab3.Adapter.menuBai2Adapter;
import com.example.lab3.Model.menuBai2;
import com.example.lab3.R;

import java.util.ArrayList;

public class Bai2 extends AppCompatActivity {
    private ArrayList<menuBai2> list = new ArrayList<>();
    ListView LV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        LV = findViewById(R.id.lvb2);

        list.add(new menuBai2(R.drawable.cafekem, "Cafe kem", "30.000"));
        list.add(new menuBai2(R.drawable.duahau, "Nước ép dưa hấu", "20.000"));
        list.add(new menuBai2(R.drawable.bo, "Sinh tố bơ", "35.000"));
        list.add(new menuBai2(R.drawable.nuoccam, "Nước cam ép", "25.000"));
        list.add(new menuBai2(R.drawable.tranh, "Nước tranh thanh mát", "20.000"));
        list.add(new menuBai2(R.drawable.trasua, "Trà sữa", "25.000"));
        menuBai2Adapter adapter = new menuBai2Adapter(list, this);
        LV.setAdapter(adapter);

    }
}