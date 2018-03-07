package com.example.administrator.xiaoshutengweb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Toast;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/7 0007.
 */

public class Act_Loding extends AppCompatActivity {
    private ViewPager myBanner;
    private int[] images = {R.mipmap.icon_p1, R.mipmap.icon_p2, R.mipmap.icon_p3};
    private List<View> datas;
    private int indext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_lod);
        myBanner = findViewById(R.id.view_pager);
        datas = new ArrayList<>();
        View view1 = LayoutInflater.from(this).inflate(R.layout.view1, null);
        View view2 = LayoutInflater.from(this).inflate(R.layout.view2, null);
        View view3 = LayoutInflater.from(this).inflate(R.layout.view3, null);
        datas.add(view1);
        datas.add(view2);
        datas.add(view3);
        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(datas);
        myBanner.setAdapter(myViewPagerAdapter);//设置适配器
        myBanner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                indext = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        myBanner.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                //继承了Activity的onTouchEvent方法，直接监听点击事件
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //当手指按下的时候
                    x1 = event.getX();
                    y1 = event.getY();
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    //当手指离开的时候
                    x2 = event.getX();
                    y2 = event.getY();
                    if (y1 - y2 > 50) {
//                Toast.makeText(Act_Loding.this, "向上滑", Toast.LENGTH_SHORT).show();
                    } else if (y2 - y1 > 50) {
//                Toast.makeText(Act_Loding.this, "向下滑", Toast.LENGTH_SHORT).show();
                    } else if (x1 - x2 > 50 && indext == 2) {

                        Intent intent = new Intent();
                        intent.setClass(Act_Loding.this, MainActivity.class);
                        startActivity(intent);
//                Toast.makeText(Act_Loding.this, "向左滑", Toast.LENGTH_SHORT).show();
                    } else if (x2 - x1 > 50) {
//                Toast.makeText(Act_Loding.this, "向右滑", Toast.LENGTH_SHORT).show();
                    }
                }
                return onTouchEvent(event);
            }
        });
    }

    double x1, y1, y2, x2;


}
