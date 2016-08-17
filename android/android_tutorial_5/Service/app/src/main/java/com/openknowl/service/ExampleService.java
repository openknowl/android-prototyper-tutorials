package com.openknowl.service;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by gracefulife on 16. 8. 17.
 */
public class ExampleService extends IntentService {
    public ExampleService() {
        super("ExampleService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Toast.makeText(getApplicationContext(), "서비스 실행되었음 !", Toast.LENGTH_SHORT).show();
    }
}


