package com.example.aditya.kjsce;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.provider.Settings.Secure;

import com.example.aditya.kjsce.Location.LocationActivity;
import com.example.aditya.kjsce.PostMethod.PostMethod;
import java.util.HashMap;

/**
 * Created by Dhwani on 9/30/2016.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String TAG = "PhoneNumber";
    SharedPreferences loginPreferences;
    SharedPreferences.Editor loginPrefsEditor;
    EditText editText1;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        Intent intent = new Intent(MainActivity.this, AccelService.class);
        startService(intent);

        Button button = (Button) findViewById(R.id.SubmitPhone);
        button.setOnClickListener(this);

        Button button1 = (Button) findViewById(R.id.family);
        button1.setOnClickListener(this);

        editText1 = (EditText) findViewById(R.id.ph_tbox1);
        editText2 = (EditText) findViewById(R.id.ph_tbox2);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {

            case R.id.SubmitPhone:

                String number1 = editText1.getText().toString();
                String number2 = editText2.getText().toString();
                String android_id = Secure.getString(getApplicationContext().getContentResolver(),
                        Secure.ANDROID_ID);

                loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
                loginPrefsEditor = loginPreferences.edit();
                loginPrefsEditor.putString("number1",number1);
                loginPrefsEditor.putString("number2",number2);
                loginPrefsEditor.commit();

                Intent intent = new Intent(MainActivity.this, LocationActivity.class);
                startActivity(intent);

                /*HashMap<String, String> hashmap = new HashMap<>();
                hashmap.put("number1", number1);
                hashmap.put("number2", number2);
                hashmap.put("id", android_id);
                String requestURL = "http://10.0.2.2:8080/api/user";
                PostMethod task = new PostMethod(hashmap, requestURL, this);
                String postReturn = "";
                try {
                    postReturn = task.execute("").get();
                    Toast.makeText(this,"Details saved",Toast.LENGTH_LONG);
                } catch (Exception e) {
                    e.printStackTrace();
                }*/
                break;

            case R.id.family:
                Intent intent1 = new Intent(MainActivity.this, RemindersActivity.class);
                startActivity(intent1);
        }
    }

}
