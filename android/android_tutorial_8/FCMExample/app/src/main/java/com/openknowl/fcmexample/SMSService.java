package com.openknowl.fcmexample;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by gracefulife on 16. 8. 17.
 */
public class SMSService extends IntentService {
    public static final MediaType CONTENT_JSON
            = MediaType.parse("application/json; charset=utf-8");
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

        final SMSMessage smsMessage = new SMSMessage(sender, message, timeMillis);

        Log.i(TAG, "on Service ..");
        Log.i(TAG, "message = " + message);
        Log.i(TAG, "sender = " + sender);
        Log.i(TAG, "timeMillis = " + timeMillis);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("messages")
                .child(String.valueOf(timeMillis))
                .setValue(smsMessage);

        final String apiKey = getApplicationContext().getString(R.string.fcm_api_key);
        mDatabase.child("partner").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String partnerTokenId = dataSnapshot.getValue(String.class);
                executeCloudMessaging(apiKey, partnerTokenId);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void executeCloudMessaging(String apiKey, String partnerTokenId) {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("notification", new JSONObject());
            jsonObject.getJSONObject("notification").put("title", "알림");
            jsonObject.getJSONObject("notification").put("text", "상대방에게 새로운 문자메세지가 도착했습니다.");

            jsonObject.put("to", partnerTokenId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(CONTENT_JSON, jsonObject.toString());

        Request request = new Request.Builder()
                .url("https://fcm.googleapis.com/fcm/send")
                .addHeader("Authorization", apiKey)
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i(TAG, "" + response.body().string());
            }
        });
    }
}


