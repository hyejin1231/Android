package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //  setContentView -> 화면에 무엇을 보여줄 것인지를 설정해 주는 역할 R.layout.activity_main -> 화면의 구성요소에 대한 정보
    }
}