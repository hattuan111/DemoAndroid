package com.example.spinner;

import android.os.Bundle;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.spinner.Adapter.abcAdapter;
import com.example.spinner.Model.abc;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    private ArrayList<abc> list = new ArrayList<>();

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
        // ánh xạ;
        spinner=findViewById(R.id.spn);
        list.add(new abc(R.drawable.instagram, "Intagram"));
        list.add(new abc(R.drawable.google, "Google"));
        list.add(new abc(R.drawable.facebook, "Facebbok"));
        list.add(new abc(R.drawable.instagram, "Intagram"));
        list.add(new abc(R.drawable.google, "Google"));
        list.add(new abc(R.drawable.facebook, "Facebbok"));
        abcAdapter adapter = new abcAdapter(MainActivity.this, list);
        spinner.setAdapter(adapter);
    }
}