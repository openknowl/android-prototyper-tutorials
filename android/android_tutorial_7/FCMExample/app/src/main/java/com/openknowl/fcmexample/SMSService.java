package com.openknowl.fcmexample;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by gracefulife on 16. 8. 17.
 */
public class SMSService extends IntentService {
    private static final String TAG = SMSService.class.getSimpleName();
    private DatabaseReference mDatabase;

    public SMSService() {
        super("SMSService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        String message = extras.getString("message");
        String sender = extras.getString("sender");
        long timeMillis = extras.getLong("timeMillis");

        SMSMessage smsMessage = new SMSMessage(sender, message, timeMillis);

        Log.i(TAG, "on Service ..");
        Log.i(TAG, "message = " + message);
        Log.i(TAG, "sender = " + sender);
        Log.i(TAG, "timeMillis = " + timeMillis);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("messages")
                .child(String.valueOf(timeMillis))
                .setValue(smsMessage);
    }
}


