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
 * Use the {@link food_2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class food_2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View root;

    public food_2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment food_2.
     */
    // TODO: Rename and change types and number of parameters
    public static food_2 newInstance(String param1, String param2) {
        food_2 fragment = new food_2();
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
        root = inflater.inflate(R.layout.fragment_food_2, container, false);
        // Inflate the layout for this fragment
        ImageView ad1 = root.findViewById(R.id.ad1);
        ImageView ad2 = root.findViewById(R.id.ad2);
        ImageView ad3 = root.findViewById(R.id.ad3);
        ImageView ad4 = root.findViewById(R.id.ad4);
        ImageView ad5 = root.findViewById(R.id.ad5);

        ppc(ad1);
        ppc(ad2);
        ppc(ad3);
        ppc(ad4);
        ppc(ad5);
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