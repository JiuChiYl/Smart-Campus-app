package com.example.jdzx;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import views.PagerItem;
import views.utLooper;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class home extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ViewPager mviewPager;
    private List<PagerItem> mData = new ArrayList<>();
    private View root;

    public home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment home.
     */
    // TODO: Rename and change types and number of parameters
    public static home newInstance(String param1, String param2) {
        home fragment = new home();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_home, container, false);


        initData();
        initView();

        LinearLayout mPage1 = root.findViewById(R.id.xlzx);
        LinearLayout mPage2 = root.findViewById(R.id.swzl);
        LinearLayout mPage3 = root.findViewById(R.id.sthd);
        LinearLayout mPage4 = root.findViewById(R.id.ygfw);
        LinearLayout mPage5 = root.findViewById(R.id.dekt);
        LinearLayout mPage6 = root.findViewById(R.id.shsj);

        moreFormPage(mPage1);
        moreFormPage(mPage2);
        moreFormPage(mPage3);
        moreFormPage(mPage4);
        moreFormPage(mPage5);
        moreFormPage(mPage6);

        CardView news1 = root.findViewById(R.id.news1);
        CardView news2 = root.findViewById(R.id.news2);
        CardView news3 = root.findViewById(R.id.news3);


        news1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),new_more_page.class));
            }
        });

        news2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), new_more_page2.class));
            }
        });

        news3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), new_more_page3.class));
            }
        });

        LinearLayout linear_more = root.findViewById(R.id.linear_more);

        linear_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), News.class));
            }
        });
        // Inflate the layout for this fragment
        return root;
    }

    public void moreFormPage(View view){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idSat = view.getId();
                if(idSat == R.id.xlzx){
                    startActivity(new Intent(getContext(), xlzx.class));
                } else if (idSat == R.id.swzl) {
                    startActivity(new Intent(getContext(), swzl.class));
                } else if (idSat == R.id.sthd) {
                    startActivity(new Intent(getContext(), sthd.class));
                } else if (idSat == R.id.ygfw) {
                    startActivity(new Intent(getContext(), ygfw.class));
                } else if (idSat == R.id.shsj) {
                    startActivity(new Intent(getContext(), shsj.class));
                } else if (idSat == R.id.dekt) {
                    startActivity(new Intent(getContext(), dekt.class));
                }
            }
        });
    }

//    载入数据
    private void initData() {
        mData.add(new PagerItem("新政策：职业教育的学生该如何发展",R.drawable.b1));
        mData.add(new PagerItem("首届世界职业院校技能大赛开幕，百余国家千余选手参赛",R.drawable.b2));
        mData.add(new PagerItem("全国人工智能职业教育集团成立",R.drawable.b3));
        mData.add(new PagerItem("广东省职业院校学生专业技能大赛“工业机器人技术应用”",R.drawable.b5));
    }
    private void initView() {
        utLooper getBanner = root.findViewById(R.id.getBanner);
        getBanner.setData(new PagerAdapter() {
            @Override
            public int getCount() {
                return Integer.MAX_VALUE;
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }
            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                View item = LayoutInflater.from(container.getContext()).inflate(R.layout.item_pager,container,false);
                ImageView iv = item.findViewById(R.id.show_img);

                int realPosition = position % mData.size();
                iv.setImageResource(mData.get(realPosition).getPicResId());
                if(iv.getParent() instanceof ViewGroup){
                    ((ViewGroup) iv.getParent()).removeView(iv);
                }
                container.addView(iv);
                return iv;
            }
            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView((View) object);
            }

        }, new utLooper.BindExList() {
            @Override
            public String getTitle(int position) {
                return mData.get(position % mData.size()).getTitle();
            }

            @Override
            public int getDataSize(){
                return mData.size();
            }
        });
    }
}