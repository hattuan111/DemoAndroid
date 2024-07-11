package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class toolBar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tool_bar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Toolbar toolbar = findViewById(R.id.tbar);
        setSupportActionBar(toolbar);//gán toolbar thay actionbar

        getSupportActionBar().setTitle("LT Mobile");
        getSupportActionBar().setSubtitle("Mobile");
        getSupportActionBar().setLogo(R.drawable.skype);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//gán nút back


    }
    // gán menu lên toolbar

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.view){
            Toast.makeText(this, "View", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId() == R.id.view1){
            Intent intent = new Intent(this, list_view.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}