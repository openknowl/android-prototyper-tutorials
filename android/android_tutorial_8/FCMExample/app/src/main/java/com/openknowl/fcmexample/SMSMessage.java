package com.openknowl.fcmexample;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by gracefulife on 16. 8. 17.
 */
@IgnoreExtraProperties
public class SMSMessage {

    public String sender;
    public String message;
    public long timeMillis;

    public SMSMessage() {
    }

    public SMSMessage(String sender, String message, long timeMillis) {
        this.sender = sender;
        this.message = message;
        this.timeMillis = timeMillis;
    }
}
