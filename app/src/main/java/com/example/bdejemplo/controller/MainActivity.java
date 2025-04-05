package com.example.bdejemplo.controller;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bdejemplo.R;
import com.example.bdejemplo.model.Datos;
import com.example.bdejemplo.model.ManangerDb;

public class MainActivity extends AppCompatActivity {

    ManangerDb manangerDb;
    SQLiteDatabase db;
    private Button btnIrCiudades, btnIrBarrios, btnIrDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIrCiudades = findViewById(R.id.btnIrCiudades);
        btnIrBarrios = findViewById(R.id.btnIrBarrios);
        btnIrDatos = findViewById(R.id.btnIrDatos);

        btnIrCiudades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCiudades = new Intent(MainActivity.this, DatosCiudad.class);
                startActivity(intentCiudades);
            }
        });


        btnIrBarrios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBarrios = new Intent(MainActivity.this, DatosBarrio.class);
                startActivity(intentBarrios);
            }
        });


        btnIrDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentDatos = new Intent(MainActivity.this, DatosTodo.class);
                startActivity(intentDatos);
            }
        });
    }
}








