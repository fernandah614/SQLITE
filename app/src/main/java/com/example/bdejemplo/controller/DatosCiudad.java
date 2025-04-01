package com.example.bdejemplo.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bdejemplo.R;
import com.example.bdejemplo.model.ManangerDb;

public class DatosCiudad extends AppCompatActivity {
    public EditText txtCodCiudad, txtNomCiudad;
    public Button guardar_Ciudad;
    public ManangerDb managerDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_ciudad);
        guardar_Ciudad = findViewById(R.id.guardar_Ciudad);

        //TextInputs
        guardar_Ciudad = findViewById(R.id.guardar_Ciudad);
        txtCodCiudad = findViewById(R.id.txtCodCiudad);
        txtNomCiudad = findViewById(R.id.txtNomCiudad);

        //Conexion base de datos
        managerDb = new ManangerDb( DatosCiudad.this);

        guardar_Ciudad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
    }
    public void save() {
        // Declaro una variable para obtener los datos de los campos de texto
        String cod_ciudad = txtCodCiudad.getText().toString();
        String nombre = txtNomCiudad.getText().toString();

        if (cod_ciudad.isEmpty() || nombre.isEmpty()) {
            Toast.makeText(this, "Ingrese la información requerida", Toast.LENGTH_SHORT).show();
            return;
        }

        // Insertamos los datos en la base de datos y verificamos el resultado
        long result = managerDb.insertCity(cod_ciudad, nombre);

        // Mostramos un mensaje según el resultado de la inserción
        if (result >0) {  // Si el valor de retorno no es -1, la inserción fue exitosa
            Toast.makeText(this, "Ciudad guardada exitosamente", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error al guardar la ciudad", Toast.LENGTH_SHORT).show();
        }
    }
}