package com.qiangshijituan.jacewharton_viewpagerindicator;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.viewpagerindicator.CirclePageIndicator;

public class MainActivity extends AppCompatActivity {

    private int[] imgs = {R.mipmap.bg_guide_one,R.mipmap.bg_guide_two,R.mipmap.bg_guide_three};
    private ImageView[] imageViews = new ImageView[imgs.length];
    private ImageView iView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        CirclePageIndicator indicator = (CirclePageIndicator) findViewById(R.id.indicator);
        initDate();
        MyAdapter adapter = new MyAdapter();
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);
    }

    private void initDate() {
        for (int i = 0 ; i<imgs.length ; i++){
            iView = new ImageView(this);
            iView.setLayoutParams(new ViewPager.LayoutParams());
            iView.setImageResource(imgs[i]);
            imageViews[i]=iView;
        }
    }
    class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return imageViews.length;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ((ViewGroup)container).addView(imageViews[position%(imageViews.length)]);
            return imageViews[position%imageViews.length];
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewGroup)container).removeView(imageViews[position%imageViews.length]);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {

            return view == object;
        }
    }
}
