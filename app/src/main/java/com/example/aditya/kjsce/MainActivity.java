package com.example.aditya.kjsce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aditya.kjsce.Location.LocationActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.location);
        button.setOnClickListener(this);


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
        }
    }
}
