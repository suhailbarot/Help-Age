package com.example.aditya.kjsce;

import android.app.IntentService;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.telephony.SmsManager;
import android.util.Log;


/**
 * Created by suhailbarot on 30/09/16.
 */
public class AccelService extends IntentService implements SensorEventListener {


    private SensorManager sensorManager;    // this instance of SensorManager class will be used to get a reference to the sensor service.
    private Sensor mSensor;         // this instance of Sensor class is used to get the sensor we want to use.
    private float[] mGravity;
    private float mAccel;
    private float mAccelCurrent;
    private float mAccelLast;


    String TAG = "AccelService";
    public void onAccuracyChanged(Sensor sensor,int accuracy){

    }
    @Override
    protected void onHandleIntent(Intent intent) {
    }

    /**
     * A constructor is required, and must call the super IntentService(String)
     * constructor with a name for the worker thread.
     */
    public AccelService() {
        super("AccelService");
    }

    /**
     * The IntentService calls this method from the default worker thread with
     * the intent that started the service. When this method returns, IntentService
     * stops the service, as appropriate.
     */


    public void onSensorChanged(SensorEvent event){


        //Log.d("Acc", Float.toString(event.values[1]));
        //Log.d("Acc", Float.toString(event.values[2]));


        /* check sensor type */
        if(event.values[1]!=0){

            Log.d("AccelService", "Accel");

            mGravity = event.values.clone();
            // assign directions
            float x=event.values[0];
            float y=event.values[1];
            float z=event.values[2];

            float x1=event.values[0];
            float y1=event.values[1];
            float z1=event.values[2];
            mAccelLast = mAccelCurrent;
            mAccelCurrent = (float)Math.sqrt(x*x + y*y + z*z);
          // we calculate the length of the event because these values are independent of the co-ordinate system.
            float delta = mAccelCurrent - mAccelLast;
            mAccel = mAccel*0.9f + delta;
            if(mAccel > 15)

            {


                sendSMS("9820066058","Check on your Dadi, Bitch");


            }
        }

       // sensorManager.unregisterListener(this);

    }

    @Override
    public void onCreate() {
        super.onCreate(); // if you override onCreate(), make sure to call super().
        // If a Context object is needed, call getApplicationContext() here.
        Log.d("AccelService", "onCreate");
        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);          // get an instance of the SensorManager class, lets us access sensors.
        mSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);    // get Accelerometer sensor from the list of sensors.
        sensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_NORMAL);

        mAccel = 0.00f;
        mAccelCurrent = SensorManager.GRAVITY_EARTH;
        mAccelLast = SensorManager.GRAVITY_EARTH;

    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Log.d("AccelService", "onStartCommand");
        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);

                                                                          // get an instance of the SensorManager class, lets us access sensors.
        mSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);    // get Accelerometer sensor from the list of sensors.

        sensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_NORMAL);

        mAccel = 0.00f;
        mAccelCurrent = SensorManager.GRAVITY_EARTH;
        mAccelLast = SensorManager.GRAVITY_EARTH;
        return START_STICKY;
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



    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}



