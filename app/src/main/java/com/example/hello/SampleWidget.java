package com.example.hello;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SampleWidget extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button);
    }
}