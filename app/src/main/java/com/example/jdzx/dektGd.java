package com.example.jdzx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class dektGd extends AppCompatActivity {

    private boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dekt_gd);

        LinearLayout exit = findViewById(R.id.exit);
        TextView butn = findViewById(R.id.butn);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        sob(butn);

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
}