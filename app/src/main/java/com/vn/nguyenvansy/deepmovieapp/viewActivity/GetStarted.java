package com.vn.nguyenvansy.deepmovieapp.viewActivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;

import com.vn.nguyenvansy.deepmovieapp.R;
import com.vn.nguyenvansy.deepmovieapp.viewPageAdapter.ViewPagerAdapter;

public class GetStarted extends AppCompatActivity {

    // creating object of ViewPager
    ViewPager mViewPager;

    // images array
    int[] images = {R.drawable.img, R.drawable.img_1, R.drawable.img_2, R.drawable.img_3};

    // Creating Object of ViewPagerAdapter
    ViewPagerAdapter mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);
        // Initializing the ViewPager Object
        mViewPager = (ViewPager)findViewById(R.id.imageViewPage);

        // Initializing the ViewPagerAdapter
        mViewPagerAdapter = new ViewPagerAdapter(GetStarted.this, images);

        // Adding the Adapter to the ViewPager
        mViewPager.setAdapter(mViewPagerAdapter);
    }
}