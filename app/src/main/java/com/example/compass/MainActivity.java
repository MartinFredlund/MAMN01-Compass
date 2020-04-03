package com.example.compass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void openCompass(View view){
        Intent intent = new Intent(this, Compass.class);
        startActivity(intent);
    }
    public void openAccelerometer(View view){
        Intent intent = new Intent(this, accelerometer.class);
        startActivity(intent);
    }
}
