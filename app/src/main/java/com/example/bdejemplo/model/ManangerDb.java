package com.example.bdejemplo.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class ManangerDb {
    DbHelper dbHelper;
    SQLiteDatabase db;
    public ManangerDb(Context context) {
        dbHelper = new DbHelper(context);

    }
    public void openDbWrite(){
        db = dbHelper.getWritableDatabase();

    }
    public void openDbRd(){
        db = dbHelper.getReadableDatabase();

    }
    public long insertData(){
      //1 abrir mi bd en modo escritura
        openDbWrite();
        //2. Crear un contenedor de valores
        ContentValues valores = new ContentValues();

        valores.put("cod_ciudad",3);
        valores.put("nombre_ciudad","Popayán");

        long resul = db.insert("Ciudad",null,valores);
        return  resul;
    }

}
