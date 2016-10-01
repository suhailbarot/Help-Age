package com.example.aditya.kjsce;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.aditya.kjsce.Location.LocationActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(MainActivity.this, AccelService.class);
        startService(intent);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.location);
        button.setOnClickListener(this);
        Button textbutton = (Button) findViewById(R.id.text);
        textbutton.setOnClickListener(this);

        Button button1 = (Button) findViewById(R.id.phonenum);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.reminders);
        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.location:
                Intent intent = new Intent(MainActivity.this, LocationActivity.class);
                startActivity(intent);
                break;

            case R.id.phonenum:
                Intent intent2 = new Intent(MainActivity.this, PhoneNumber.class);
                startActivity(intent2);
                break;

            case R.id.text:
                Intent intent1 = new Intent(MainActivity.this, SMSActivity.class);
                startActivity(intent1);

            case R.id.reminders:
                Intent intent3 = new Intent(MainActivity.this, RemindersActivity.class);
                startActivity(intent3);

        }



    }

}
