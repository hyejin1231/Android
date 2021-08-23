package com.example.hello;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

public class SampleScrollView extends AppCompatActivity {

    ScrollView scrollView;
    ImageView imageView3;
    BitmapDrawable bitmapDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_scroll_view);

        scrollView = findViewById(R.id.scrollView);
        imageView3 = findViewById(R.id.imageView3);
        scrollView.setHorizontalScrollBarEnabled(true);

        Resources rs = getResources();
        bitmapDrawable = (BitmapDrawable) rs.getDrawable(R.drawable.clouds);
        int bitmapWidth = bitmapDrawable.getIntrinsicWidth();
        int bitmapHeight = bitmapDrawable.getIntrinsicHeight();

        imageView3.setImageDrawable(bitmapDrawable);
        imageView3.getLayoutParams().width = bitmapWidth;
        imageView3.getLayoutParams().height = bitmapHeight;
    }


    public void onButtonScroll(View v){
        changeImage();
    }

    private void changeImage(){
        Resources rs = getResources();
        bitmapDrawable = (BitmapDrawable) rs.getDrawable(R.drawable.moon);
        int bitmapWidth = bitmapDrawable.getIntrinsicWidth();
        int bitmapHeight = bitmapDrawable.getIntrinsicHeight();

        imageView3.setImageDrawable(bitmapDrawable);
        imageView3.getLayoutParams().width = bitmapWidth;
        imageView3.getLayoutParams().height = bitmapHeight;
    }
}