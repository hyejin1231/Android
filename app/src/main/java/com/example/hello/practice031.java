package com.example.hello;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class practice031 extends AppCompatActivity {

    ImageView imageView4;
    ImageView imageView5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice031);

        imageView4 = findViewById(R.id.imageView4);
        imageView5= findViewById(R.id.imageView5);

        Button btn_up = findViewById(R.id.btn_up);
        Button btn_down = findViewById(R.id.btn_down);

        btn_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveImageUp();
            }
        });

        btn_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveImageDown();
            }
        });

    }

    private void moveImageUp() {
        imageView4.setImageResource(R.drawable.moon);
        imageView5.setImageResource(0);

        imageView4.invalidate();
        imageView5.invalidate();
    }

    private  void moveImageDown() {
        imageView4.setImageResource(0);
        imageView5.setImageResource(R.drawable.moon);

        imageView4.invalidate();
        imageView5.invalidate();
    }
}