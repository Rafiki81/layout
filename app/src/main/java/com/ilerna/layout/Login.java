package com.ilerna.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class Login extends AppCompatActivity {

    Button buttonLogin;
    EditText nombreUsuario;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buttonLogin = findViewById(R.id.button);
        password = findViewById(R.id.editTextTextPassword);
        nombreUsuario = findViewById(R.id.editTextTextPersonName2);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcionLogin(v);
            }
        });
    }

    private void funcionLogin(View v) {
        BaseDatos bbdd = new BaseDatos(this,"CanApp",null,1);


        if(bbdd.getData().isEmpty()){
            Toast.makeText(this, getString(R.string.noUsers), Toast.LENGTH_SHORT).show();
        }else{
            for(Usuario usuario:bbdd.getData()){
                if(usuario.getNombreUsuario().equals(nombreUsuario.getText().toString()) && usuario.getPassword().equals(password.getText().toString())){
                    Toast.makeText(this, getString(R.string.message_login), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this,SoundActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(this, getString(R.string.userPassMismatch), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}