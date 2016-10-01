package com.example.aditya.kjsce;/*
    Created by JEELAALI on 1/10/16.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button health = (Button) findViewById(R.id.health_butt);
        health.setOnClickListener(this);

        Button safety = (Button) findViewById(R.id.safety_butt);
        health.setOnClickListener(this);

        Button editProfile = (Button) findViewById(R.id.editprofile);
        editProfile.setOnClickListener(this);

        Button cheat = (Button) findViewById(R.id.cheat);
        cheat.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.health_butt:
                break;
            case R.id.safety_butt:
                break;
            case R.id.editprofile:
                Intent intent = new Intent(HomeActivity.this, RemindersActivity.class);
                startActivity(intent);
                break;
            case R.id.cheat:
                sendSMS("9820136330", "We have detected some unusual activity(a fall). Please check on the as soon as possible");
                sendSMS("9619708661", "We have detected some unusual activity(a fall). Please check on the as soon as possible");

        }
    }

    protected void sendSMS(String number,String mess) {
        Log.d("SMS","InSMSFucnt");
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(number, null, mess, null, null);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
