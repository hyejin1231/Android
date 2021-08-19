package com.example.hello;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    TextView tv_result;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        tv_result = findViewById(R.id.tv_result);

        Intent intent = getIntent();
        result = intent.getExtras().getString("result");

        tv_result.setText(result);
    }
}