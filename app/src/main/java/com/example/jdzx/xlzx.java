package com.example.jdzx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class xlzx extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xlzx);

        LinearLayout exit = findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        CardView c1l = findViewById(R.id.c1l);
        CardView c2l = findViewById(R.id.c2l);
        CardView c3l = findViewById(R.id.c3l);
        CardView c4l = findViewById(R.id.c4l);
        CardView c5l = findViewById(R.id.c5l);

        LinearLayout pag1 = findViewById(R.id.pag1);
        LinearLayout pag2 = findViewById(R.id.pag2);
        LinearLayout pag3 = findViewById(R.id.pag3);
        LinearLayout pag4 = findViewById(R.id.pag4);
        LinearLayout pag5 = findViewById(R.id.pag5);

        clickShow(c1l);
        clickShow(c2l);
        clickShow(c3l);
        clickShow(c4l);
        clickShow(c5l);

        tzC(pag1);
        tzC(pag2);
        tzC(pag3);
        tzC(pag4);
        tzC(pag5);

    }
    public void clickShow(CardView cardView){
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(xlzx.this, "预约成功!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void tzC(View v){
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(xlzx.this, yuyxq.class));
            }
        });
    }
}