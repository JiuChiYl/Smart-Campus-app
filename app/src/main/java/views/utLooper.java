package views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.jdzx.R;

public class utLooper extends LinearLayout {

    private ViewPager viewPager;
    private LinearLayout point;
    private TextView title;
    private BindExList mTitleSetLister = null;
    private PagerAdapter mInnerAdapter = null;

    public utLooper(Context context) {
        this(context,null);
    }

    public utLooper(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public utLooper(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.looper_pager,this,true);
        init();
    }

    private void init() {
        initView();
        initEvent();
    }

    private void initEvent() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                切换回调
                
            }

            @Override
            public void onPageSelected(int position) {
//               切换停止回调
//                停止后切换标题
                if (mTitleSetLister != null) {
                    title.setText(mTitleSetLister.getTitle(position));
                }
                setUpIndicatorPoint();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
//               状态改变回调
            }
        });
    }


    public interface BindExList{
        String getTitle(int position);

        int getDataSize();

    }

    public void setData(PagerAdapter innerAdapter, BindExList lister){
        this.mTitleSetLister = lister;
        viewPager.setAdapter(innerAdapter);
        viewPager.setCurrentItem(Integer.MAX_VALUE / 2 + 1);
        this.mInnerAdapter = innerAdapter;

        setUpIndicatorPoint();
    }

    private void setUpIndicatorPoint() {
        if (mInnerAdapter != null && mTitleSetLister != null) {
            int count = mTitleSetLister.getDataSize();
            point.removeAllViews();
            for (int i = 0; i < count; i++) {
                View points = new View(getContext());
                if(viewPager.getCurrentItem() % mTitleSetLister.getDataSize() == i){
                    points.setBackgroundResource(R.drawable.sh2);
                } else {
                    points.setBackgroundResource(R.drawable.radio);
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(SizeUtils.dip2px(getContext(), 5.5f),SizeUtils.dip2px(getContext(),5.5f));
                layoutParams.setMargins(10,10,10,10);
                points.setLayoutParams(layoutParams);
                point.addView(points);
            }
        }
    }

    private void initView() {
        viewPager = this.findViewById(R.id.banner_page);
        point = this.findViewById(R.id.banner_item);
        title = this.findViewById(R.id.banner_title);
    }
}
