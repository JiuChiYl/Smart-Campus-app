package com.example.jdzx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;

public class FoCm extends AppCompatActivity {

    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fo_cm);

        Button exit = findViewById(R.id.exit);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = true;
                startActivity(new Intent(FoCm.this, login.class));
            }
        });

        CountDownTimer countDownTimer = new CountDownTimer(6000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                exit.setText((millisUntilFinished / 1000)+"秒 关闭");
            }

            @Override
            public void onFinish() {
                if (flag == false){
                    startActivity(new Intent(FoCm.this, login.class));
                }else {
                    return;
                }
            }
        }.start();
    }
}