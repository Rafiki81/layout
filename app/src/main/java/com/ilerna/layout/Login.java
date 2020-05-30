package com.ilerna.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buttonLogin = findViewById(R.id.button);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcionLogin(v);
            }
        });
    }

    private void funcionLogin(View v) {

        Toast.makeText(this, getString(R.string.message_login), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Login.this,SoundActivity.class);
        startActivity(intent);
    }
}