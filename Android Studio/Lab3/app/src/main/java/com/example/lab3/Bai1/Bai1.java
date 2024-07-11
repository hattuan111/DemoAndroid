package com.example.lab3.Bai1;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab3.Adapter.bai1Adapter;
import com.example.lab3.Model.bai1;
import com.example.lab3.R;

import java.util.ArrayList;

public class Bai1 extends AppCompatActivity {
    private ArrayList<bai1> list = new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listView=findViewById(R.id.listview);
        list.add(new bai1(R.drawable.facebook, "Facebbok"));
        list.add(new bai1(R.drawable.instagram, "Intagram"));
        list.add(new bai1(R.drawable.linkedin, "Linkedin"));
        list.add(new bai1(R.drawable.skype, "Skype"));
        list.add(new bai1(R.drawable.yahoo, "Yahoo"));
        list.add(new bai1(R.drawable.twitter, "Twitter"));

        bai1Adapter adapter = new bai1Adapter(this, list);
        listView.setAdapter(adapter);
    }
}