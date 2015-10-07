package com.rakshith.restaurant.ViewPageSlider;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.rakshith.restaurant.MyAdapter.TestFragment;
import com.rakshith.restaurant.R;

import java.util.ArrayList;


public class TestFragmentAdapter extends FragmentPagerAdapter  {
    ArrayList<Integer> CONTENT;


     static  String[] Tile = new String[] {
          "chesse1","chesse2","chesse3","chesse4"
    };
    private int mCount;

    public TestFragmentAdapter(FragmentManager fm, ArrayList<Integer> CONTENT, String[] Tile) {
        super(fm);
        this.CONTENT=CONTENT;
        mCount = CONTENT.size();
        this.Tile=Tile;
    }

    @Override
    public Fragment getItem(int position) {
        return TestFragment.newInstance(CONTENT.get(position %  CONTENT.size()));
    }

    @Override
    public int getCount() {
        return mCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {

      return TestFragmentAdapter.Tile[position % Tile.length];
    }



    public void setCount(int count) {
        if (count > 0 && count <= 10) {
            mCount = count;
            notifyDataSetChanged();
        }
    }
}