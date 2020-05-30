package com.ilerna.layout;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BaseDatos extends SQLiteOpenHelper {

    public BaseDatos(@Nullable Context context,
                     @Nullable String name,
                     @Nullable SQLiteDatabase.CursorFactory factory,
                     int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE usuarios (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT," +
                "apellido TEXT," +
                "nombreUsuario TEXT," +
                "email TEXT," +
                "password TEXT);";
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertData(String nombre, String apellido, String nombreUsuario, String email, String password){
        SQLiteDatabase escritura = getWritableDatabase();
        String insert = "INSERT INTO usuarios (nombre,apellido,nombreUsuario,email,password) " +
                "VALUES (\"" + nombre + "\",\"" + apellido + "\",\"" + nombreUsuario + "\",\"" + email + "\",\"" + password + "\");";
        escritura.execSQL(insert);
        escritura.close();
    }

    public List<Usuario> getData(){
        SQLiteDatabase lectura = getReadableDatabase();
        String consulta = "SELECT * FROM usuarios";
        Cursor cursor = lectura.rawQuery(consulta,null);
        cursor.moveToFirst();
        List<Usuario> usuarios = new ArrayList<>();
        do{
            usuarios.add(new Usuario(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5)));
        }while(cursor.moveToNext());
        lectura.close();
        return usuarios;
    }


}
