package com.example.jdzx;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link food#newInstance} factory method to
 * create an instance of this fragment.
 */
public class food extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View root;
    private int yuan;
    private TextView eyuan;
    private food_1 food1;

    public food() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment food.
     */
    // TODO: Rename and change types and number of parameters
    public static food newInstance(String param1, String param2) {
        food fragment = new food();
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
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_food, container, false);

        eyuan = root.findViewById(R.id.yuan);

        food1 = new food_1();



        TextView food_zc = root.findViewById(R.id.food_zc);
        TextView food_wc = root.findViewById(R.id.food_wc);
        TextView food_wanc = root.findViewById(R.id.food_wanc);
        TextView food_xy = root.findViewById(R.id.food_xy);

        food_1 b1 = new food_1();

        food_zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnTextColorView(food_zc);
                setOffTextColorView(food_wc);
                setOffTextColorView(food_wanc);
                setOffTextColorView(food_xy);

                replaceFragment(new food_1());
            }
        });
        food_wc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnTextColorView(food_wc);
                setOffTextColorView(food_zc);
                setOffTextColorView(food_wanc);
                setOffTextColorView(food_xy);

                replaceFragment(new food_2());
            }
        });
        food_wanc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnTextColorView(food_wanc);
                setOffTextColorView(food_wc);
                setOffTextColorView(food_zc);
                setOffTextColorView(food_xy);

                replaceFragment(new food_3());
            }
        });
        food_xy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnTextColorView(food_xy);
                setOffTextColorView(food_wc);
                setOffTextColorView(food_wanc);
                setOffTextColorView(food_zc);

                replaceFragment(new food_4());
            }
        });

        return root;
    }

    public void setOnTextColorView(TextView v){
        v.setBackgroundColor(getResources().getColor(R.color.ble));
        v.setTextColor(getResources().getColor(R.color.white));
    }
    public void setOffTextColorView(TextView v){
        v.setBackgroundColor(getResources().getColor(R.color.white));
        v.setTextColor(getResources().getColor(R.color.ble));
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.getMidFragment,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onResume() {
        super.onResume();

        food1.setFragmentCallBack(new IFragmentCallBack() {
            @Override
            public void sendMsgToActivity(Integer i) {
                eyuan.setText(i);
            }

            @Override
            public Integer getMsgFromActivity(Integer i) {
                eyuan.setText(i);

                return 10048;
            }
        });
    }
}