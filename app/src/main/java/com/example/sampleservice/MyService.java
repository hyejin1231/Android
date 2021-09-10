package com.example.sampleservice;

import android.app.Service;
import android.content.Intent;
import android.nfc.Tag;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    private static final String TAG = "MyService";
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "oncreate() 호출됨.");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    // 메서드와 인텐트 객체를 전달받기 위한 메서드
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand() 호출됨.");

        if (intent == null) {
            return Service.START_STICKY;
        }else {
            String command = intent.getStringExtra("command");
            String contents = intent.getStringExtra("contents");

            Log.d(TAG, "command : " + command + ", contents : " + contents);

            for (int i = 0; i< 5; i++) {
                try{
                    Thread.sleep(1000);
                }catch (Exception e) {

                };

                Log.d(TAG, "wating " + i + "second.");
//            processCommand(intent);
        }
        return super.onStartCommand(intent, flags, startId);
    }


//    private void processCommand(Intent intent) {
//        String command = intent.getStringExtra("command");
//        String contents = intent.getStringExtra("contents");
//
//        Log.d(TAG, "command : " + command + ", contents : " + contents);
//
//        for (int i = 0; i< 5; i++) {
//            try{
//                Thread.sleep(1000);
//            }catch (Exception e) {
//
//            };
//
//            Log.d(TAG, "wating " + i + "second.");
//
//        }
//
//        Intent showIntent = new Intent(getApplicationContext(), MainActivity.class);
//
//        showIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        showIntent.putExtra("command", "show");
//        showIntent.putExtra("contents",contents + "from service");
//        startActivity(showIntent);
    }
}





















