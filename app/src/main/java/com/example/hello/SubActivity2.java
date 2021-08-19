package com.example.hello;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity2 extends AppCompatActivity {

    TextView tv_result2;
    String result2;
    Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);

        tv_result2 = findViewById(R.id.tv_result);
        btn_send =findViewById(R.id.btn_send);

//        Intent intent = getIntent();
//        result2 = intent.getExtras().getString("result2");
//
//        tv_result2.setText(result2);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });

    }
}