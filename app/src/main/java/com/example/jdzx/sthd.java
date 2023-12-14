package com.example.jdzx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class sthd extends AppCompatActivity {

    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sthd);

        LinearLayout exit = findViewById(R.id.exit);

        TextView cl1 = findViewById(R.id.cl1);
        TextView cl2 = findViewById(R.id.cl2);
        TextView cl3 = findViewById(R.id.cl3);

        LinearLayout card1 = findViewById(R.id.card1);
        LinearLayout card2 = findViewById(R.id.card2);
        LinearLayout card3 = findViewById(R.id.card3);

        tzC(card1);
        tzC(card2);
        tzC(card3);

        sob(cl1);
        sob(cl2);
        sob(cl3);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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
                startActivity(new Intent(sthd.this, stxq.class));
            }
        });
    }
}