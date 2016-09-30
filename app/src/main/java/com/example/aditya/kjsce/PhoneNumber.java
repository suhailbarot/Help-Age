package com.example.aditya.kjsce;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aditya.kjsce.Location.LocationActivity;

/**
 * Created by Dhwani on 9/30/2016.
 */

public class PhoneNumber extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        Button button = (Button) findViewById(R.id.SubmitPhone);
        button.setOnClickListener(this);

        EditText editText1 = (EditText) findViewById(R.id.ph_tbox1);
        EditText editText2 = (EditText) findViewById(R.id.ph_tbox2);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {

            case R.id.SubmitPhone:
                Toast.makeText(this, "Your data has been saved", Toast.LENGTH_LONG).show();
        }
    }

}
