package com.example.jdzx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ygfw extends AppCompatActivity {

    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ygfw);

        TextView bm1 = findViewById(R.id.bm1);
        TextView bm2 = findViewById(R.id.bm2);
        TextView bm3 = findViewById(R.id.bm3);

        LinearLayout card1 = findViewById(R.id.card1);
        LinearLayout card2 = findViewById(R.id.card2);
        LinearLayout card3 = findViewById(R.id.card3);

        LinearLayout exit = findViewById(R.id.exit);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        sob(bm1);
        sob(bm2);
        sob(bm3);

        tzC(card1);
        tzC(card2);
        tzC(card3);

    }
    public void sob(View view){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag){
                    Toast.makeText(v.getContext(), "一人只能报名一次哦！", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(v.getContext(), "报名成功！", Toast.LENGTH_SHORT).show();
                }
                flag = true;
            }
        });
    }
    public void tzC(View v){
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ygfw.this, ygxq.class));
            }
        });
    }
}