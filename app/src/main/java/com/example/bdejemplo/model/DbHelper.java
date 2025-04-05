package com.example.bdejemplo.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(@Nullable Context context) {
        super(context, Constantes.NAME_BD, null, Constantes.NAME_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constantes.SENTECIACIUDAD);
        db.execSQL(Constantes.CREARDATOS);
        db.execSQL(Constantes.CREARBARRIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Ciudad");
        db.execSQL("DROP TABLE IF EXISTS Datos");
        db.execSQL("DROP TABLE IF EXISTS Barrio");
        onCreate(db);
    }

}
