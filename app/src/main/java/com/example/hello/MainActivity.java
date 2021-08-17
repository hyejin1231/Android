package com.example.hello;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //  setContentView -> 화면에 무엇을 보여줄 것인지를 설정해 주는 역할 R.layout.activity_main -> 화면의 구성요소에 대한 정보
    }

    public void onButton1Clicked(View view){
        Toast.makeText(this, "확인1 버튼이 눌렸어요!", Toast.LENGTH_SHORT).show();
    }

    public void onButton2Clicked(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(intent);
    }

    public void onButton3Clicked(View view) {
        Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-0000-0000"));
        startActivity(intent1);
    }
 }