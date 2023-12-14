package com.example.jdzx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class dekt extends AppCompatActivity {

    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Context context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dekt);

        LinearLayout exit = findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView ca1 = findViewById(R.id.ca1);
        TextView ca2 = findViewById(R.id.ca2);
        TextView ca3 = findViewById(R.id.ca3);
        TextView ca4 = findViewById(R.id.ca4);
        TextView ca5 = findViewById(R.id.ca5);
        TextView ca6 = findViewById(R.id.ca6);
        TextView ca7 = findViewById(R.id.ca7);

        sob(ca1);
        sob(ca2);
        sob(ca3);
        sob(ca4);
        sob(ca5);
        sob(ca6);
        sob(ca7);

        LinearLayout bu1 = findViewById(R.id.bu1);
        LinearLayout bu2 = findViewById(R.id.bu2);
        LinearLayout bu3 = findViewById(R.id.bu3);
        LinearLayout bu4 = findViewById(R.id.bu4);
        LinearLayout bu5 = findViewById(R.id.bu5);
        LinearLayout bu6 = findViewById(R.id.bu6);
        LinearLayout bu7 = findViewById(R.id.bu7);

        cllr(bu1);
        cllr(bu2);
        cllr(bu3);
        cllr(bu4);
        cllr(bu5);
        cllr(bu6);
        cllr(bu7);
    }
        public void sob(TextView view){
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

        public void cllr(LinearLayout layout){
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(dekt.this, dektGd.class));
                }
            });
        }
}