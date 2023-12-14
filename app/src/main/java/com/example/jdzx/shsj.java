package com.example.jdzx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class shsj extends AppCompatActivity {

    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shsj);

        LinearLayout exit = findViewById(R.id.exit);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView bm1 = findViewById(R.id.bm1);
        TextView bm2 = findViewById(R.id.bm2);
        TextView bm3 = findViewById(R.id.bm3);

        sob(bm1);
        sob(bm2);
        sob(bm3);
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
}