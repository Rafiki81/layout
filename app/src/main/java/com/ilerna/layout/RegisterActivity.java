package com.ilerna.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    Button buttonRegister;
    EditText nombre;
    EditText apellido;
    EditText nombreUsuario;
    EditText email;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        buttonRegister = findViewById(R.id.button);
        nombre = findViewById(R.id.TextPersonName);
        apellido = findViewById(R.id.TextSurname);
        nombreUsuario = findViewById(R.id.TextUserName);
        email = findViewById(R.id.TextEmail);
        password = findViewById(R.id.TextPassword);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        BaseDatos bbdd = new BaseDatos(this,"CanApp",null,1);
        if(nombre.getText().toString().equals("")){
            Toast.makeText(this, getString(R.string.message_name_empty), Toast.LENGTH_SHORT).show();
        }else if(apellido.getText().toString().equals("")){
            Toast.makeText(this, getString(R.string.message_login), Toast.LENGTH_SHORT).show();
        }else if(apellido.getText().toString().equals("")){
            Toast.makeText(this, getString(R.string.message_login), Toast.LENGTH_SHORT).show();
        }else if(nombreUsuario.getText().toString().equals("")){
            Toast.makeText(this, getString(R.string.message_login), Toast.LENGTH_SHORT).show();
        }else if(email.getText().toString().equals("")){
            Toast.makeText(this, getString(R.string.message_login), Toast.LENGTH_SHORT).show();
        }else if(password.getText().toString().equals("")){
            Toast.makeText(this, getString(R.string.message_login), Toast.LENGTH_SHORT).show();
        }else{
            bbdd.insertData(nombre.getText().toString(),apellido.getText().toString(),nombreUsuario.getText().toString(),email.getText().toString(),password.getText().toString());
            Toast.makeText(this, getString(R.string.message_create), Toast.LENGTH_SHORT).show();
        }


    }

}
