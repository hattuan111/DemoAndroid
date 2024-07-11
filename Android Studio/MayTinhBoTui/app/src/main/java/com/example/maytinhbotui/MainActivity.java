package com.example.maytinhbotui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button so1, so2, so3, so4, so5, so6, so7, so8, so9;
    private Button cong, tru, nhan, chia, ac, pt, pd, so0, bang, phay;
    private TextView tvInput, tvOutput;
    private String number = null;
    double lastNumber=0, firstNumber=0;
    boolean operator=false;
    private String status = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        anhxa();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        so0.setOnClickListener(view -> numberClick("0"));
        so1.setOnClickListener(view -> numberClick("1"));
        so2.setOnClickListener(view -> numberClick("2"));
        so3.setOnClickListener(view -> numberClick("3"));
        so4.setOnClickListener(view -> numberClick("4"));
        so5.setOnClickListener(view -> numberClick("5"));
        so6.setOnClickListener(view -> numberClick("6"));
        so7.setOnClickListener(view -> numberClick("7"));
        so8.setOnClickListener(view -> numberClick("8"));
        so9.setOnClickListener(view -> numberClick("9"));
        cong.setOnClickListener(view -> {
            if(status == "tru"){
                Tru();
            }else {
                if(status == "chia"){
                    Chia();
                }else {
                    if(status == "nhan"){
                        Nhan();
                    }else {
                        Cong();
                    }
                }
            }
            operator = false;
            number = null;
            status= "cong";
        });
        tru.setOnClickListener(view -> {
            if(status == "nhan"){
                Nhan();
            }else {
                if(status == "chia"){
                    Chia();
                }else {
                    if(status == "cong"){
                        Cong();
                    }else {
                        Tru();
                    }
                }
            }
            operator = false;
            number = null;
            status= "tru";
        });
        nhan.setOnClickListener(view -> {
            if(status == "cong"){
                Cong();
            }else {
                if(status == "chia"){
                    Chia();
                }else {
                    if(status == "tru"){
                        Tru();
                    }else {
                        Nhan();
                    }
                }
            }
            operator = false;
            number = null;
            status= "nhan";
        });
        chia.setOnClickListener(view -> {
            if(status == "nhan"){
                Nhan();
            }else {
                if(status == "cong"){
                    Cong();
                }else {
                    if(status == "tru"){
                        Tru();
                    }else {
                        Chia();
                    }
                }
            }
            operator = false;
            number = null;
            status= "chia";
        });
        bang.setOnClickListener(view -> {
            if(status == "cong"){
                Cong();
            }else {
                if(status == "tru"){
                    Tru();
                }else {
                    if(status == "nhan"){
                        Nhan();
                    }else if(status == "chia"){
                        Chia();
                    }else {
                        tvInput.setText("");
                        firstNumber = Double.parseDouble(tvOutput.getText().toString());
                        tvOutput.setText(("" + firstNumber));

                    }
                }
            }
            operator = false;
        });
        pt.setOnClickListener(view -> {
            if(status == "cong"){
                Cong();
            }else {
                if(status == "tru"){
                    Tru();
                }else {
                    if(status == "nhan"){
                        Nhan();
                    }else if(status == "chia"){
                        Chia();
                    } else {
                        firstNumber = Double.parseDouble(tvInput.getText().toString());
                        firstNumber = firstNumber / 100;
                        tvOutput.setText("" + firstNumber);
                    }
                }
            }
            operator = false;
        });
        ac.setOnClickListener(view -> {
            number = null;
            operator= false;
            tvInput.setText("");
            tvOutput.setText("");
            firstNumber = 0;
            lastNumber = 0;
        });
        phay.setOnClickListener(view -> {
            if(number == null){
                number = "0.";
            }else {
                number = number + ".";
            }
            tvInput.setText(number);
        });
    }
    public void anhxa(){
        so0 = this.findViewById(R.id.so0);
        so1 = this.findViewById(R.id.so1);
        so2 = this.findViewById(R.id.so2);
        so3 = this.findViewById(R.id.so3);
        so4 = this.findViewById(R.id.so4);
        so5 = this.findViewById(R.id.so5);
        so6 = this.findViewById(R.id.so6);
        so7 = this.findViewById(R.id.so7);
        so8 = this.findViewById(R.id.so8);
        so9 = this.findViewById(R.id.so9);

        cong = this.findViewById(R.id.cong);
        tru = this.findViewById(R.id.tru);
        nhan = this.findViewById(R.id.nhan);
        chia = this.findViewById(R.id.chia);

        ac = this.findViewById(R.id.AC);
        pd = this.findViewById(R.id.PD);
        pt = this.findViewById(R.id.PT);
        phay = this.findViewById(R.id.phay);
        bang = this.findViewById(R.id.bang);

        tvInput = this.findViewById(R.id.input);
        tvOutput = this.findViewById(R.id.output);

    }
    public void numberClick(String view){
        if(number == null){
            number = view;
        }else {
            number = number + view;
        }
        tvInput.setText(number);
        operator = true;
    }
    public void Tru(){
        if(firstNumber == 0){
            firstNumber = Double.parseDouble(tvInput.getText().toString());
        }else {
            lastNumber = Double.parseDouble(tvInput.getText().toString());
            firstNumber = firstNumber - lastNumber;
        }
        tvOutput.setText("" + firstNumber);
    }
    public void Cong(){
        lastNumber = Double.parseDouble(tvInput.getText().toString());
        firstNumber = firstNumber + lastNumber;
        tvOutput.setText(("" + firstNumber));
    }
    public void Nhan() {
        lastNumber = Double.parseDouble(tvInput.getText().toString());
        if (firstNumber == 0) {
            firstNumber = lastNumber;
        } else {
            firstNumber = firstNumber * lastNumber;
        }
        tvOutput.setText("" + firstNumber);
    }
    public void Chia() {
        if (firstNumber == 0) {
            firstNumber = Double.parseDouble(tvInput.getText().toString());
        } else {
            lastNumber = Double.parseDouble(tvInput.getText().toString());
            if (lastNumber != 0) {
                firstNumber = firstNumber / lastNumber;
                tvOutput.setText("" + firstNumber);
            } else {
                tvOutput.setText("Error: Division by zero");
            }
        }
    }
}