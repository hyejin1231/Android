package com.example.hello;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LifeCycle extends AppCompatActivity {


    EditText et1, et2;
    TextView tvResult;
    Button btnAction, btnSend, btnSend2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_life_cycle);

        Log.d("myapp", "onCreate");

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        tvResult = findViewById(R.id.tvResult);
        btnAction = findViewById(R.id.btnAction);
        btnSend = findViewById(R.id.btnSend);
        btnSend2 = findViewById(R.id.btnSend2);
        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(et1.getText().toString().trim());
                int b = Integer.parseInt(et2.getText().toString().trim());
                tvResult.setText("" + (a + b));
            }
        });


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LifeCycle.this, SubActivity.class);
                intent.putExtra("result",tvResult.getText().toString());
                startActivity(intent);
            }
        });

        btnSend2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LifeCycle.this, SubActivity2.class);
                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0){
            if (resultCode==RESULT_OK) {
                Toast.makeText(LifeCycle.this, "result ok!", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(LifeCycle.this, "result cancle!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("myapp", "onStart");
    }

    // 액티비티가 동작하기 시작할 때 , 사용자와 상호작용
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("myapp", "onResume");
    }

    // 다른 액티비티가 보여지기 시작할 때,( 가려지기 시작할 때)
    // 액티비티에서 다루던 데이터, 백업 저장 쓰래드 중지 .... 처리를 함
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("myapp", "onPause");
    }

    // 액티비티가 더이상 안보여질 때 호출
    // (경우에 따라서는 호출안되고 곧바로 onDestroy 로 가기도 함 )
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("myapp", "onStop");
    }

    // 액티비티 소멸
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("myapp", "onDestroy");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("myapp", "onRestart");
    }

    // 액티비티가 소멸되기 전에 호출된다.
    // 주의! onPause 뒤에 호출된다고 간주하지 말 것 !!
    //       onDestroy 직전에 호출된다고 간주하지 말 것 !!!
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("myapp", "onSaveInstanceState");

        outState.putString("value",tvResult.getText().toString());
    }


    // 직전에 저장된 액티비티 상태정보(Bundle)이 있다면,
    // onRestoreInstanceState 는 onStart 직후에 호출됨.
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("myapp" ,"onRestoreInstanceState");

        if (savedInstanceState != null) {
            tvResult.setText(savedInstanceState.getString("value"));
        }
    }


}

