package com.example.jdzx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class News extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        ImageView exit = findViewById(R.id.exit);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        CardView mo1 = findViewById(R.id.mo1);
        CardView mo2 = findViewById(R.id.mo2);
        CardView mo3 = findViewById(R.id.mo3);
        CardView mo4 = findViewById(R.id.mo4);
        CardView mo5 = findViewById(R.id.mo5);
        CardView mo6 = findViewById(R.id.mo6);

        page1(mo1);
        page2(mo2);
        page3(mo3);

        page1(mo4);
        page3(mo5);
        page2(mo6);
    }

    public void page1(CardView cardView){
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(News.this,new_more_page.class));
            }
        });
    }
    public void page2(CardView cardView){
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(News.this,new_more_page2.class));
            }
        });
    }
    public void page3(CardView cardView){
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(News.this,new_more_page3.class));
            }
        });
    }
}