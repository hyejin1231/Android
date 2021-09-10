package com.example.sampleservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Measure;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SmsReceiver extends BroadcastReceiver {

    public static final String TAG = "SmsReceiver";


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "onReceive() 메서드 호출됨");

        Bundle bundle = intent.getExtras();
        SmsMessage[] messages = parseSmsMessage(bundle);

        if (messages != null & messages.length > 0 ) {
            String sender = messages[0].getOriginatingAddress();
            Log.i(TAG, "SMS sender : " + sender);

            String contents = messages[0].getMessageBody();
            Log.i(TAG, "SMS contents : " + contents);

            Date receivedDate = new Date(messages[0].getTimestampMillis());
            Log.i(TAG, "SMS recieved date : " + receivedDate.toString());

            sendToActivity(context, sender, contents, receivedDate);
        }
    }

    public SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private SmsMessage[] parseSmsMessage(Bundle bundle) {
        Object[] objects = (Object[]) bundle.get("pdus");
        SmsMessage[] messages = new SmsMessage[objects.length];

        int SmsCount = objects.length;
        for (int i = 0; i< SmsCount; i++) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                String format = bundle.getString("format");
                messages[i] = SmsMessage.createFromPdu((byte[]) objects[i], format);

            }else {
                messages[i] = SmsMessage.createFromPdu((byte[]) objects[i] );
            }
        }

        return messages;
    }

    private  void sendToActivity(Context context, String sender, String contents, Date receivedDate) {
        Intent myIntent = new Intent(context, SmsActivity.class);


        myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);

        myIntent.putExtra("sender", sender);
        myIntent.putExtra("contents", contents);
        myIntent.putExtra("receivedDate", format.format(receivedDate));

        context.startActivity(myIntent);
    }
}