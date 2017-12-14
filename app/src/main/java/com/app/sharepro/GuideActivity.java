package com.app.sharepro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.app.sharepro.transformer.ZoomOutPageTransformer;
import com.app.sharepro.util.StateBarUtil;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity {

  private ViewPager mViewPager;

  private int[] mImgIds = new int[] {
      R.drawable.guide_image1, R.drawable.guide_image2, R.drawable.guide_image3
  };

  private List<ImageView> mImages = new ArrayList<>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_guide);

    //透明状态栏效果
    StateBarUtil.setStateBar(this);

    mViewPager = findViewById(R.id.vp_test);

    //为ViewPager添加切换动画效果, 3.0以后才有效果
    mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());

    mViewPager.setAdapter(new PagerAdapter() {
      @Override
      public Object instantiateItem(ViewGroup container, int position) {

        ImageView imageView = new ImageView(GuideActivity.this);
        imageView.setImageResource(mImgIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        container.addView(imageView);
        mImages.add(imageView);

        return imageView;
      }

      @Override
      public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mImages.get(position));
      }

      @Override
      public int getCount() {
        return mImgIds.length;
      }

      @Override
      public boolean isViewFromObject(View view, Object object) {
        return view == object;
      }
    });


    mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

      private boolean flag;

      @Override
      public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
      }

      @Override
      public void onPageSelected(int position) {
      }

      @Override
      public void onPageScrollStateChanged(int state) {
        switch(state) {
          case ViewPager.SCROLL_STATE_DRAGGING:
            flag = false;
            break;
          case ViewPager.SCROLL_STATE_SETTLING:
            flag = true;
            break;
          case ViewPager.SCROLL_STATE_IDLE:
            if(mViewPager.getCurrentItem() == mViewPager.getAdapter().getCount() - 1 && !flag) {
              startActivity(new Intent(GuideActivity.this, LoginActivity.class));
              finish();
            }
            flag = true;
            break;
        }
      }
    });
  }



}
