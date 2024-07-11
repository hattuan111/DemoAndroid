package com.example.bai2_lab3;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<MenuItem> list = new ArrayList<>();
    ListView listView;
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
        listView=findViewById(R.id.listView);
        list.add(new MenuItem(R.drawable.cafekem, "Cafe", "10.000"));
        list.add(new MenuItem(R.drawable.trasua, "Trà sữa", "15.000"));
        list.add(new MenuItem(R.drawable.duahau, "Nươc ép dưa hấu", "15.000"));
        list.add(new MenuItem(R.drawable.tranh, "Nước tranh thanh mát", "10.000"));
        list.add(new MenuItem(R.drawable.nuoccam, "Nước ép cam", "10.000"));
        list.add(new MenuItem(R.drawable.bo, "Sinh tố bơ", "20.000"));
        MenuItemAdapter adapter = new MenuItemAdapter(this, list);
        listView.setAdapter(adapter);
    }
}