package com.example.hello;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SampleOrientation extends AppCompatActivity {
    String name;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_orientation);
        showToast("onCraete() 호출됨");

        editText = findViewById(R.id.editText);

        Button btn_orientaion = findViewById(R.id.btn_orientaion);

        btn_orientaion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editText.getText().toString();
                showToast("입력된 값을 변수에 저장했습니다." + name);
            }
        });

        if (savedInstanceState != null) {
            name = savedInstanceState.getString("name");
            showToast("값이 복원되었습니다." + name);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        //showToast("onStart() 호출됨");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showToast("onStop() 호출됨");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showToast("onDestroy() 호출됨");
    }

    public void showToast(String data) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(@NonNull  Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("name", name);
    }
}