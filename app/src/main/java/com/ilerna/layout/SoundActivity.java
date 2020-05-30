package com.ilerna.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SoundActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound);
    }

    public void ladrar(View view){
        Intent intent = new Intent(this,SoundService.class);
        startService(intent);
    }

    public void parar(View view){
        Intent intent = new Intent(this,SoundService.class);
        stopService(intent);
    }
}