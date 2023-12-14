package com.example.jdzx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

import views.PagerItem;
import views.user;
import views.utLooper;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences config;

//    private ViewPager mviewPager;
//    private List<PagerItem> mData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        config = getSharedPreferences("config", Context.MODE_PRIVATE);


        String resMessage = config.getString("SchoolName","NotFind");

//        initData();
//        initView();
        BottomNavigationView bnv = findViewById(R.id.getMenu);
        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.nav_home) {
                    replaceFragment(new home());
                } else if (item.getItemId() == R.id.nav_zb) {
                    replaceFragment(new zhibo());
                } else if (item.getItemId() == R.id.nav_food) {
                    replaceFragment(new food());
                } else if (item.getItemId() == R.id.nv_me) {
                    replaceFragment(new user());
                }
                return true;
            }
        });

    }
//    private void initData() {
//        mData.add(new PagerItem("公告提醒1",R.drawable.b1));
//        mData.add(new PagerItem("公告提醒2",R.drawable.b2));
//        mData.add(new PagerItem("公告提醒3",R.drawable.b3));
//        mData.add(new PagerItem("公告提醒4",R.drawable.b5));
//    }
//    private void initView() {
//        utLooper getBanner = findViewById(R.id.getBanner);
//        getBanner.setData(new PagerAdapter() {
//            @Override
//            public int getCount() {
//                return Integer.MAX_VALUE;
//            }
//
//            @Override
//            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
//                return view == object;
//            }
//            @NonNull
//            @Override
//            public Object instantiateItem(@NonNull ViewGroup container, int position) {
//                View item = LayoutInflater.from(container.getContext()).inflate(R.layout.item_pager,container,false);
//                ImageView iv = item.findViewById(R.id.show_img);
//
//            int realPosition = position % mData.size();
//            iv.setImageResource(mData.get(realPosition).getPicResId());
//            if(iv.getParent() instanceof ViewGroup){
//                ((ViewGroup) iv.getParent()).removeView(iv);
//            }
//            container.addView(iv);
//            return iv;
//        }
//            @Override
//            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//                container.removeView((View) object);
//            }
//
//        }, new utLooper.BindExList() {
//            @Override
//            public String getTitle(int position) {
//                return mData.get(position % mData.size()).getTitle();
//            }
//
//            @Override
//            public int getDataSize(){
//                return mData.size();
//            }
//        });
//    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.getFragment,fragment);
        fragmentTransaction.commit();
    }
}