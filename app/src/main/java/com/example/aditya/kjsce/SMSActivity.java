package com.example.aditya.kjsce;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by suhailbarot on 30/09/16.
 */
public class SMSActivity extends AppCompatActivity{


    Button sendSMSBtn;
    EditText toPhoneNumberET;
    EditText smsMessageET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("SMS", "InSMS");
        String stra = getIntent().getExtras().getString("accel");

        if(stra=="acc"){
            sendSMS("9820066058","Check on your Dadi, Bitch");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    protected void sendSMS(String number,String mess) {
        Log.d("SMS","InSMSFucnt");
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(number, null, mess, null, null);
    }


}
