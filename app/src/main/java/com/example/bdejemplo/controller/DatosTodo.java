package com.example.bdejemplo.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bdejemplo.R;
import com.example.bdejemplo.model.ManangerDb;
public class DatosTodo extends AppCompatActivity {
    public EditText edt_cod, edt_nombre, edt_apellido, edt_direccion, edt_cod_ciudad;
    public Button btn_guardarDatos;
    public ManangerDb manangerDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_todo);

        edt_cod = findViewById(R.id.edt_codigo);
        edt_nombre = findViewById(R.id.edt_nombre);
        edt_apellido = findViewById(R.id.edt_apellido);
        edt_direccion = findViewById(R.id.edt_direccion);
        edt_cod_ciudad = findViewById(R.id.edt_cod_ciudad);
        btn_guardarDatos = findViewById(R.id.btn_guardarDatos);

        manangerDb = new ManangerDb(DatosTodo.this);


        if (!manangerDb.ciudadExiste("1")) {
            manangerDb.insertCiudad("1", "Bogotá");
        }

        btn_guardarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
    }

    public void save() {
        String nombre = edt_nombre.getText().toString().trim();
        String apellido = edt_apellido.getText().toString().trim();
        String direccion = edt_direccion.getText().toString().trim();
        String cod_ciudad = edt_cod_ciudad.getText().toString().trim();

        if (nombre.isEmpty()) {
            Toast.makeText(this, "Ingrese su nombre", Toast.LENGTH_SHORT).show();
            return;
        }

        if (apellido.isEmpty()) {
            Toast.makeText(this, "Ingrese su apellido", Toast.LENGTH_SHORT).show();
            return;
        }

        if (direccion.isEmpty()) {
            Toast.makeText(this, "Ingrese su dirección", Toast.LENGTH_SHORT).show();
            return;
        }

        if (cod_ciudad.isEmpty()) {
            Toast.makeText(this, "Ingrese el código de ciudad", Toast.LENGTH_SHORT).show();
            return;
        }

        long result = manangerDb.insertTodo(nombre, apellido, direccion, cod_ciudad);

        if (result > 0) {
            Toast.makeText(this, "Datos guardados correctamente", Toast.LENGTH_SHORT).show();
            edt_nombre.setText("");
            edt_apellido.setText("");
            edt_direccion.setText("");
            edt_cod_ciudad.setText("");
        } else {
            Toast.makeText(this, "Error al guardar los datos", Toast.LENGTH_SHORT).show();
        }
    }
}
