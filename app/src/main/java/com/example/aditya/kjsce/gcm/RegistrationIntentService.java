package com.example.aditya.kjsce.gcm;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.example.aditya.kjsce.R;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

public class RegistrationIntentService extends IntentService {

    private static final String TAG = "RegIntentService";
    SharedPreferences loginPreferences;
    SharedPreferences.Editor loginPrefsEditor;

    public RegistrationIntentService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        try {
            InstanceID instanceID = InstanceID.getInstance(this);
          //  String token = instanceID.getToken(getString(R.string.gcm_defaultSenderId),
               //     GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);

          //  Log.i(TAG, "GCM Registration Token: " + token);

            loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
            loginPrefsEditor = loginPreferences.edit();
         //   loginPrefsEditor.putString("gcmToken",token);
            loginPrefsEditor.commit();

        } catch (Exception e) {
            Log.d(TAG, "Failed to complete token refresh", e);
        }

        Intent registrationComplete = new Intent(QuickstartPreferences.REGISTRATION_COMPLETE);
        LocalBroadcastManager.getInstance(this).sendBroadcast(registrationComplete);
    }
}
