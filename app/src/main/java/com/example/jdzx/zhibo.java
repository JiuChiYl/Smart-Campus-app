package com.example.jdzx;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link zhibo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class zhibo extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View root;
    private int[] rob;
    private int[] rob2;
    private boolean flag;
    private ImageView playa;
    private VideoView videoView;

    public zhibo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment zhibo.
     */
    // TODO: Rename and change types and number of parameters
    public static zhibo newInstance(String param1, String param2) {
        zhibo fragment = new zhibo();
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
        root = inflater.inflate(R.layout.fragment_zhibo, container, false);

        EditText search = root.findViewById(R.id.search_input);

        videoView = root.findViewById(R.id.videoView);
        playa = root.findViewById(R.id.playa);
        FrameLayout VideoPlay = root.findViewById(R.id.VideoPlay);

        VideoPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controlFlag();
            }
        });



        LinearLayout show_lb = root.findViewById(R.id.show_lb);
        LinearLayout lb = root.findViewById(R.id.lb);
        show_lb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lb.setVisibility(View.VISIBLE);
            }
        });
        ImageView exitLab = root.findViewById(R.id.exitLab);
        exitLab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lb.setVisibility(View.GONE);
            }
        });

        TextView lb_1 = root.findViewById(R.id.lb_1);
        TextView lb_2 = root.findViewById(R.id.lb_2);
        TextView lb_3 = root.findViewById(R.id.lb_3);
        TextView lb_4 = root.findViewById(R.id.lb_4);
        TextView lb_5 = root.findViewById(R.id.lb_5);

        clClick2(lb_1);
        clClick2(lb_2);
        clClick2(lb_3);
        clClick2(lb_4);
        clClick2(lb_5);

//        File file = new File("file://voa1.mp4");
        videoView.setVideoPath("android.resource://" + getContext().getPackageName()+"/" + R.raw.voa1);
        MediaController mc = new MediaController(videoView.getContext());

        videoView.setMediaController(mc);
        videoView.requestFocus();

        videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controlFlag();
            }
        });


        Button bo1 = root.findViewById(R.id.vo1);
        Button bo2 = root.findViewById(R.id.vo2);
        Button bo3 = root.findViewById(R.id.vo3);
        Button bo4 = root.findViewById(R.id.vo4);
        Button bo5 = root.findViewById(R.id.vo5);
        Button bo6 = root.findViewById(R.id.vo6);
        Button bo7 = root.findViewById(R.id.vo7);
        Button bo8 = root.findViewById(R.id.vo8);

        clClick(bo1);
        clClick(bo2);
        clClick(bo3);
        clClick(bo4);
        clClick(bo5);
        clClick(bo6);
        clClick(bo7);
        clClick(bo8);

        search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String string_search = search.getText().toString();

                Intent intent = new Intent(getContext(), search.class);
                intent.putExtra("rest",string_search);
                startActivity(intent);
                return true;
            }
        });

        // Inflate the layout for this fragment
        return root;
    }
    public void controlFlag(){
        if (!flag){
            flag = true;
            videoView.start();
            CountDownTimer countDownTimer = new CountDownTimer(100,1000) {
                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {
                    playa.setVisibility(View.GONE);
                }
            }.start();
        }
    }
    public void clClick(Button button){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int bstn = button.getId();
                rob = new int[]{
                        R.id.vo1,
                        R.id.vo2,
                        R.id.vo3,
                        R.id.vo4,
                        R.id.vo5,
                        R.id.vo6,
                        R.id.vo7,
                        R.id.vo8
                };
                for (int i = 0; i < rob.length; i++) {
                    if(rob[i] == bstn){
                        button.setBackgroundResource(R.drawable.border3);
                        button.setTextColor(getResources().getColor(R.color.white));
                    } else {
                        Button ros = root.findViewById(rob[i]);
                        ros.setTextColor(getResources().getColor(R.color.ble));
                        ros.setBackgroundResource(R.drawable.border2);
                    }
                }
            }
        });
    }

    public void clClick2(TextView button){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int bstn2 = button.getId();
                rob2 = new int[]{
                        R.id.lb_1,
                        R.id.lb_2,
                        R.id.lb_3,
                        R.id.lb_4,
                        R.id.lb_5
                };
                for (int i = 0; i < rob2.length; i++) {
                    if(rob2[i] == bstn2){
                        button.setBackgroundResource(R.color.ble);
                        button.setTextColor(getResources().getColor(R.color.white));
                    } else {
                        TextView ros = root.findViewById(rob2[i]);
                        ros.setTextColor(getResources().getColor(R.color.ble));
                        ros.setBackgroundResource(R.color.white);
                    }
                }
            }
        });
    }
}