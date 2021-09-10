package com.example.sampleservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String contents = editText.getText().toString();

                Intent intent = new Intent(getApplicationContext(), MyService.class);
                intent.putExtra("command", "show");
                intent.putExtra("contents", contents);

                startService(intent);
            }
        });

//        Intent passedIntent = getIntent();
//        processIntent(passedIntent);

    }


    // 액티비티가 이미 만들어져 있을 때 전달된 인텐트 처리하기
//    @Override
//    protected void onNewIntent(Intent intent) {
//        processIntent(intent);
//        super.onNewIntent(intent);
//    }

//    private  void processIntent(Intent intent) {
//        if (intent != null) {
//            String command = intent.getStringExtra("command");
//            String name = intent.getStringExtra("name");
//
//            Toast.makeText(getApplicationContext(), "command : " + command + ", name : " + name, Toast.LENGTH_SHORT).show();
//        }
//    }
}