package com.example.aditya.kjsce;/*
    Created by JEELAALI on 1/10/16.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RemindersActivity extends AppCompatActivity {
    EditText remindername,date,e1,e2;
    Button b1,b2;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reminders);
        e1=(EditText) findViewById(R.id.rems_editText2);
        e2=(EditText) findViewById(R.id.rems_edit4);
        e1.setText(0+"");
        e2.setText(0+"");

    }
    public void fun(View v)
    {
        remindername=(EditText) findViewById(R.id.rems_editText1);
        date=(EditText) findViewById(R.id.rems_editText3);

    }
    public void inc(View v)
    {
        b1=(Button) findViewById(R.id.plus_hours);
        b2=(Button) findViewById(R.id.plus_minutes);
        if(v.getId()==b1.getId())
        {
            String s = e1.getText().toString();
            int a= Integer.parseInt(s);
            a++;
            if(a>23)
                a=0;
            e1.setText(a+"");
        }
        if(v.getId()==b2.getId())
        {
            String s = e2.getText().toString();
            int a= Integer.parseInt(s);
            a+=10;
            if(a>60){
                a=0;
            }
            e2.setText(a+"");
        }
    }
    public void dec(View v)
    {
        b1=(Button) findViewById(R.id.minus_hours);
        b2=(Button) findViewById(R.id.minus_minutes);
        if(v.getId()==b1.getId())
        {
            String s = e1.getText().toString();
            int a= Integer.parseInt(s);
            a--;
            if(a<0)
                a=23;
            e1.setText(a+"");
        }
        if(v.getId()==b2.getId())
        {
            String s = e2.getText().toString();
            int a= Integer.parseInt(s);
            a=a-10;
            if(a<0){
                a=60;
            }
            e2.setText(a+"");
        }
    }

}
