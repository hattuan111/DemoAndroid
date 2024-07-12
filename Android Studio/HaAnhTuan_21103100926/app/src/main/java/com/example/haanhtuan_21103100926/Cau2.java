package com.example.haanhtuan_21103100926;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Cau2 extends AppCompatActivity {
    private EditText txtMa, txtDiem, txtTuoi;
    private RadioGroup rgGender;
    private RadioButton rdoNam, rdoNu;
    private Button btnSubmit, btnClear;
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
        txtMa = findViewById(R.id.txtMa);
        txtDiem = findViewById(R.id.txtDiem);
        txtTuoi = findViewById(R.id.txtTuoi);
        rgGender = findViewById(R.id.rgGender);
        rdoNam = findViewById(R.id.rdoNam);
        rdoNu = findViewById(R.id.rdoNu);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnClear = findViewById(R.id.btnClear);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(kiemTra()){
                    Intent intent = new Intent(Cau2.this, Cau3.class);
                    startActivity(intent);
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
            }
        });
    }
    private boolean kiemTra() {
        String maSV = txtMa.getText().toString().trim();
        String diemStr = txtDiem.getText().toString().trim();
        String tuoiStr = txtTuoi.getText().toString().trim();

        if (maSV.isEmpty() && maSV.equals("21103100296")) {
            Toast.makeText(this, "Mã sinh viên không được để trống", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (diemStr.isEmpty()) {
            Toast.makeText(this, "Điểm không được để trống", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(!"21103100904".equals(maSV)){
            Toast.makeText(this, "Mã sinh viên không được để trống", Toast.LENGTH_SHORT).show();

            return false;
        }

        float diem;
        try {
            diem = Float.parseFloat(diemStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Điểm phải là một số", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (diem < 0 || diem > 10) {
            Toast.makeText(this, "Điểm phải nằm trong khoảng từ 0 đến 10", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (rgGender.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Vui lòng chọn giới tính", Toast.LENGTH_SHORT).show();
            return false;
        }

        int tuoi;
        try {
            tuoi = Integer.parseInt(tuoiStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Tuổi phải là một số", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (rdoNam.isChecked() && (tuoi < 20 || tuoi > 65)) {
            Toast.makeText(this, "Tuổi phải từ 20 đến 65 đối với Nam", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (rdoNu.isChecked() && (tuoi < 18 || tuoi > 60)) {
            Toast.makeText(this, "Tuổi phải từ 18 đến 60 đối với Nữ", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void clear() {
        txtMa.setText("");
        txtDiem.setText("");
        txtTuoi.setText("");
        rgGender.clearCheck();
    }
}