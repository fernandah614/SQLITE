package com.example.bdejemplo.controller;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bdejemplo.R;
import com.example.bdejemplo.model.ManangerDb;

public class MainActivity extends AppCompatActivity {

   ManangerDb manangerDb;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // INSTANCIAR A MI CLASE QUE TIENE LA CONEXION
        manangerDb = new ManangerDb(MainActivity.this);
       long resul= manangerDb.insertData();


       if(resul>0){
           Toast.makeText(this, "Datos insertados" + resul, Toast.LENGTH_SHORT).show();

       }

       else{

           Toast.makeText(this, "Datos no insertados"+ resul, Toast.LENGTH_SHORT).show();

       }





    }
}
