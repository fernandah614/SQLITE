package com.example.bdejemplo.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bdejemplo.R;
import com.example.bdejemplo.model.ManangerDb;
public class DatosBarrio extends AppCompatActivity {
    public EditText edt_cod,edt_nombre;
    public Button btn_guardarBarrio;
    public ManangerDb manangerDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_barrio);

        edt_cod = findViewById(R.id.edt_cod);
        edt_nombre = findViewById(R.id.edt_nom);
        btn_guardarBarrio = findViewById(R.id.btn_guardarBarrio);

        manangerDb = new ManangerDb(DatosBarrio.this);
        btn_guardarBarrio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
    }

    public void save() {
        String nombre = edt_nombre.getText().toString().trim();

        if (nombre.isEmpty()) {
            Toast.makeText(this, "Ingrese el nombre del barrio", Toast.LENGTH_SHORT).show();
            return;
        }

        long resultado = manangerDb.insertBarrio(nombre);

        if (resultado > 0) {
            Toast.makeText(this, "Barrio guardado correctamente", Toast.LENGTH_SHORT).show();
            edt_nombre.setText("");
        } else {
            Toast.makeText(this, "Error al guardar el barrio", Toast.LENGTH_SHORT).show();
        }
    }

}
