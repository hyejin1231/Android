package com.example.hello;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SampleEvnet extends AppCompatActivity {

    TextView textView19;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_evnet);

        textView19 = findViewById(R.id.textView19);

        GestureDetector detector;

        View view =findViewById(R.id.view);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();

                float curX = event.getX();
                float curY = event.getY();

                if(action == event.ACTION_DOWN) {
                    println("손가락 눌림 : " + curX + ", " + curY);
                }else if(action == event.ACTION_MOVE) {
                    println("손가락 움직임 : " + curX + ", " + curY);
                }else if(action == event.ACTION_UP) {
                    println("손가락 뗌 : " + curX + ", " + curY);
                }

                return true;
            }
        });

        detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                println("onDown() 호출됨");
                return true;
            }

            @Override
            public void onShowPress(MotionEvent e) {
                println("onShowPress() 호출됨");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                println("onSingleTapUp() 호출됨 ");
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                println("onScroll() 호출됨 : " + distanceX + ", " + distanceY);
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                println("onLongPress() 호출됨");
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                println("onFling() 호출됨 " + velocityX + ", "+ velocityY);
                return true;
            }
        });

        View view2 = findViewById(R.id.view2);

        view2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                detector.onTouchEvent(event);
                return true;
            }
        });


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == event.KEYCODE_BACK) {
            Toast.makeText(this, "시스템 [Back] 버튼이 눌렸습니다.", Toast.LENGTH_SHORT).show();

            return  true;

        }
        return false;
    }

    public  void println(String data){
        textView19.append(data + "\n");
    }
}