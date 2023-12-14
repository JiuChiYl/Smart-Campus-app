package com.example.jdzx;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link food_1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class food_1 extends Fragment {


    private View root;

    public food_1() {
        // Required empty public constructor
    }


    private IFragmentCallBack fragmentCallBack;
    public void setFragmentCallBack(IFragmentCallBack callBack){
        fragmentCallBack = callBack;
    }

    public static food_1 newInstance(String param1, String param2) {
        food_1 fragment = new food_1();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_food_1, container, false);
        // Inflate the layout for this fragment

        ImageView ad1 = root.findViewById(R.id.ad1);
        ImageView ad2 = root.findViewById(R.id.ad2);
        ImageView ad3 = root.findViewById(R.id.ad3);
        ImageView ad4 = root.findViewById(R.id.ad4);
        ppc(ad1);
        ppc(ad2);
        ppc(ad3);
        ppc(ad4);
        return root;
    }
    private void ppc(View view){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "已加入购物车", Toast.LENGTH_SHORT).show();
            }
        });
    }

}