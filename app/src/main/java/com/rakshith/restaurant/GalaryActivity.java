package com.rakshith.restaurant;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Rakshith on 10/6/2015.
 */
public class GalaryActivity extends AppCompatActivity {
    ImageView imageView1;
    Toolbar mToolbar;
    TextView toolbar_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.galary);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        intialize();
        toolbar_title.setText(this.getResources().getString(R.string.galary));

    }

    private void intialize() {
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        toolbar_title=(TextView)this.findViewById(R.id.toolbar_title);
       /* ViewTreeObserver vto = imageView1.getViewTreeObserver();
        vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                int x,y;
                imageView1.getViewTreeObserver().removeOnPreDrawListener(this);
                x = imageView1.getMeasuredWidth();
                y = imageView1.getMeasuredWidth();
                if(x>y)
                imageView1.setLayoutParams(new LinearLayout.LayoutParams(y,y));
                else
                    imageView1.setLayoutParams(new LinearLayout.LayoutParams(x,x));
                return true;
            }
        });*/


        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //What to do on back clicked
                finish();
            }
        });
    }
}
