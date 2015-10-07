package com.rakshith.restaurant;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rakshith.restaurant.MyAdapter.MenuAdapter;
import com.rakshith.restaurant.dao.MenuItem;
import com.rakshith.restaurant.dao.NavDrawerItem;
import com.rakshith.restaurant.side_menu.NavigationDrawerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rakshith on 10/6/2015.
 */
public class MenuActivity extends AppCompatActivity {
    RecyclerView mMenuList;
    Toolbar mToolbar;
    MenuAdapter adapter;
    MenuItem mMenuItem;
    TextView toolbar_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        intialize();
        toolbar_title.setText(this.getResources().getString(R.string.menu));

        adapter = new MenuAdapter(this, getData());
        mMenuList.setAdapter(adapter);
        mMenuList.setLayoutManager(new LinearLayoutManager(this));
    }

    private List<MenuItem> getData() {
        List<MenuItem> menuList=new ArrayList<MenuItem>();
        mMenuItem=new MenuItem();
        mMenuItem.setImageId(R.drawable.cheese_1);
        menuList.add(mMenuItem);
        mMenuItem=new MenuItem();
        mMenuItem.setImageId(R.drawable.cheese_2);
        menuList.add(mMenuItem);
        mMenuItem=new MenuItem();
        mMenuItem.setImageId(R.drawable.cheese_3);
        menuList.add(mMenuItem);
        mMenuItem=new MenuItem();
        mMenuItem.setImageId(R.drawable.cheese_4);
        menuList.add(mMenuItem);

        mMenuItem=new MenuItem();
        mMenuItem.setImageId(R.drawable.cheese_1);
        menuList.add(mMenuItem);
        mMenuItem=new MenuItem();
        mMenuItem.setImageId(R.drawable.cheese_2);
        menuList.add(mMenuItem);
        mMenuItem=new MenuItem();
        mMenuItem.setImageId(R.drawable.cheese_3);
        menuList.add(mMenuItem);
        mMenuItem=new MenuItem();
        mMenuItem.setImageId(R.drawable.cheese_4);
        menuList.add(mMenuItem);

        return menuList;
    }

    private void intialize() {
        mMenuList=(RecyclerView)this.findViewById(R.id.mMenuList);
        toolbar_title=(TextView)this.findViewById(R.id.toolbar_title);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //What to do on back clicked
                finish();
            }
        });
    }


}