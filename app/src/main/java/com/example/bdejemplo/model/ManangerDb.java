package com.example.bdejemplo.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class ManangerDb {
    private DbHelper dbHelper;

    public ManangerDb(Context context){
        dbHelper = new DbHelper(context);
    }

    public long insertCiudad(String codigo, String nombre) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nombre", nombre);
        long result = db.insert("Ciudad", null, valores);
        db.close();
        return result;
    }


    public boolean ciudadExiste(String codigo) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT 1 FROM Ciudad WHERE cod = ?", new String[]{codigo});
        boolean existe = cursor.moveToFirst();
        cursor.close();
        db.close();
        return existe;
    }

    public long insertBarrio(String nombre) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nombre", nombre);
        long result = db.insert("Barrio", null, valores);
        db.close();
        return result;
    }

    public long insertTodo(String nombre, String apellido, String direccion, String cod_ciudad) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nombre", nombre);
        valores.put("apellido", apellido);
        valores.put("direccion", direccion);
        valores.put("cod_ciudad", Integer.parseInt(cod_ciudad));
        long result = db.insert("Datos", null, valores);
        db.close();
        return result;
    }

}
