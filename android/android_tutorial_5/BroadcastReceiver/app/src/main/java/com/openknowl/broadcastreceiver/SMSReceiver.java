package com.openknowl.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.telephony.SmsMessage;
import android.util.Log;

/**
 * Created by gracefulife on 16. 8. 12.
 */
public class SMSReceiver extends BroadcastReceiver {

    private static final String TAG = SMSReceiver.class.getSimpleName();
    private static final String RECEIVE_SMS = "android.provider.Telephony.SMS_RECEIVED";


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "onReceive..");
        String sdcardState = Environment.getExternalStorageState();
        if (!sdcardState.contentEquals(Environment.MEDIA_MOUNTED)) {
            return;
        }

        if (RECEIVE_SMS.equals(intent.getAction())) {
            Bundle bundle = intent.getExtras();
            if (bundle == null) {
                return;
            }

            Object[] pdu = (Object[]) bundle.get("pdus");
            if (pdu == null) {
                return;
            }

            SmsMessage[] receiveMessage = new SmsMessage[pdu.length];
            for (int i = 0; i < pdu.length; i++) {
                receiveMessage[i] = SmsMessage.createFromPdu((byte[]) pdu[i]);
                Log.e(TAG, "NEW SMS " + i + "th");
                Log.e(TAG, "DisplayOriginatingAddress : "
                        + receiveMessage[i].getDisplayOriginatingAddress());
                Log.e(TAG, "DisplayMessageBody : "
                        + receiveMessage[i].getDisplayMessageBody());
                Log.e(TAG, "EmailBody : "
                        + receiveMessage[i].getEmailBody());
                Log.e(TAG, "EmailFrom : "
                        + receiveMessage[i].getEmailFrom());
                Log.e(TAG, "OriginatingAddress : "
                        + receiveMessage[i].getOriginatingAddress());
                Log.e(TAG, "MessageBody : "
                        + receiveMessage[i].getMessageBody());
                Log.e(TAG, "ServiceCenterAddress : "
                        + receiveMessage[i].getServiceCenterAddress());
                Log.e(TAG, "TimestampMillis : "
                        + receiveMessage[i].getTimestampMillis());

            }
        }
    }
}
