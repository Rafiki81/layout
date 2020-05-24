package com.ilerna.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonRegister;
    Button buttonLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonRegister = findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                functionRegister(v);
            }
        });

        buttonLogin = findViewById(R.id.buttonlogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcionLogin(v);
            }
        });
    }

    private void functionRegister(View v) {

        Toast.makeText(this, getString(R.string.message_register), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
        startActivity(intent);
    }

    public void funcionLogin(View v){

        Toast.makeText(this, getString(R.string.message_login), Toast.LENGTH_SHORT).show();
    }
}
