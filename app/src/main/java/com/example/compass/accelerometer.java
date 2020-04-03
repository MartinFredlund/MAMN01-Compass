package com.example.compass;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

    public class accelerometer extends Activity implements SensorEventListener {
        TextView txt_xValue;
        TextView txt_yValue;
        TextView txt_zValue;
        TextView txt_direction;
        private SensorManager sensorManager;
        private Sensor mAccelerometer;
        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_accelerometer);
            txt_xValue = findViewById(R.id.xValue);
            txt_yValue = findViewById(R.id.yValue);
            txt_zValue = findViewById(R.id.zValue);
            txt_direction = findViewById(R.id.direction);

            sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
            start();
        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                getAccelerometer(event);
            }

        }

        private void getAccelerometer(SensorEvent event) {
            double[] linear_acceleration = new double[3];
            linear_acceleration[0] = event.values[0];
            linear_acceleration[1] = event.values[1];
            linear_acceleration[2] = event.values[2];
            txt_xValue.setText("X: " +Double.toString(linear_acceleration[0]));
            txt_yValue.setText("Y: " +Double.toString(linear_acceleration[1]));
            txt_zValue.setText("Z: " +Double.toString(linear_acceleration[2]));
            if(event.values[0]>-1 && event.values[0] < 1 && event.values[1]<1&& event.values[1]>-1){
                txt_direction.setText("Stilla");
            }
            else if(event.values[0] > 2){
                txt_direction.setText("Vänster");
            }
            else if (event.values[0] < -2){
                txt_direction.setText("Höger");
            }
            else if(event.values[1] < -2){
                txt_direction.setText("Fram");
            }
            else if(event.values[1] > 2){
                txt_direction.setText("Bak");
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
        private void start(){
            mAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
        }
}
