package com.example.bdejemplo.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bdejemplo.R;
import com.example.bdejemplo.model.ManangerDb;
public class DatosCiudad extends AppCompatActivity {

    public EditText edt_cod, edt_nom;
    public Button btn_guardarCiudad;
    public ManangerDb managerDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_ciudad);


        edt_cod = findViewById(R.id.edt_cod);
        edt_nom = findViewById(R.id.edt_nom);
        btn_guardarCiudad = findViewById(R.id.btn_guardarCiudad);


        managerDb = new ManangerDb(DatosCiudad.this);


        btn_guardarCiudad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
    }

    public void save() {
        String codigo = edt_cod.getText().toString().trim();
        String nombre = edt_nom.getText().toString().trim();


        if (codigo.isEmpty()) {
            Toast.makeText(this, "Ingrese el código de la ciudad", Toast.LENGTH_SHORT).show();
            return;
        }
        if (nombre.isEmpty()) {
            Toast.makeText(this, "Ingrese el nombre de la ciudad", Toast.LENGTH_SHORT).show();
            return;
        }


        long resultado = managerDb.insertCiudad(codigo, nombre);


        if (resultado > 0) {
            Toast.makeText(this, "Ciudad guardada correctamente", Toast.LENGTH_SHORT).show();
            edt_cod.setText("");
            edt_nom.setText("");
        } else {
            Toast.makeText(this, "Error al guardar la ciudad", Toast.LENGTH_SHORT).show();
        }
    }
}
