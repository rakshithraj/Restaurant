package com.rakshith.restaurant;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rakshith.restaurant.ViewPageIndicator.CirclePageIndicator;
import com.rakshith.restaurant.ViewPageIndicator.PageIndicator;
import com.rakshith.restaurant.side_menu.FragmentDrawer;
import com.rakshith.restaurant.ViewPageSlider.TestFragmentAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener,View.OnClickListener {
    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;

    TestFragmentAdapter mAdapter;
    ViewPager mPager;
    PageIndicator mIndicator;
    TextView tvPageTitle,toolbar_title;

    Button btGalary,btmenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        intialize();
        toolbar_title.setText(this.getResources().getString(R.string.home));
        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);


        ArrayList<Integer> CONTENT=new   ArrayList<Integer>();
        CONTENT.add(R.drawable.cheese_1);
        CONTENT.add(R.drawable.cheese_2);
        CONTENT.add(R.drawable.cheese_3);
        CONTENT.add(R.drawable.cheese_4);


        final String[] Tile = new String[] {
                "chesse1","chesse2","chesse3","chesse4"
        };


        mAdapter = new TestFragmentAdapter(getSupportFragmentManager(),CONTENT,Tile);

        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        final CirclePageIndicator indicator = (CirclePageIndicator)findViewById(R.id.indicator);
        mIndicator = indicator;
        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;
        indicator.setBackgroundColor(Color.parseColor("#88BE8454"));
        indicator.setRadius(10 * density);
        indicator.setPageColor(Color.parseColor("#886346"));
        indicator.setFillColor(Color.WHITE);
          indicator.setStrokeColor(0xFF000000);
        indicator.setStrokeWidth(2 * density);
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tvPageTitle.setText(Tile[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tvPageTitle.setText(Tile[indicator.getmCurrentPage()]);

        btGalary=(Button)this.findViewById(R.id.btGalary);
        btGalary.setOnClickListener(this);
        btmenu=(Button)this.findViewById(R.id.btmenu);
        btmenu.setOnClickListener(this);


    }

    private void intialize() {
        tvPageTitle=(TextView)this.findViewById(R.id.tvPageTitle);
        toolbar_title=(TextView)this.findViewById(R.id.toolbar_title);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.btGalary:
                 intent =new Intent(this,GalaryActivity.class);
                this.startActivity(intent);
                break;
            case R.id.btmenu:
                 intent =new Intent(this,MenuActivity.class);
                this.startActivity(intent);
                break;
        }
    }
}
