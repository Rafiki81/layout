package com.ilerna.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SoundActivity extends AppCompatActivity {
    Button ladrar;
    Button parar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound);

        ladrar = findViewById(R.id.ladrar);
        parar = findViewById(R.id.parar);

        ladrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ladrar(v);
            }
        });
        parar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parar(v);
            }
        });
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