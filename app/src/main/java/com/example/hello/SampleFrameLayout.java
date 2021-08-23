package com.example.hello;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SampleFrameLayout extends AppCompatActivity {

    ImageView imageView, imageView2;
    int imageIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_frame_layout);

        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
    }

    public void onButtonChanged(View v) {
        changeImage();
    }

    private void changeImage() {
        if(imageIndex ==  0){
            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);

            imageIndex = 1;
        }else if(imageIndex == 1) {
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);

            imageIndex = 0;
        }
    }
}