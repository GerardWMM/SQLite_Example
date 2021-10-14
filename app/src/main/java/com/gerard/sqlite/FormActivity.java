package com.gerard.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gerard.sqlite.Models.Categoria;
import com.gerard.sqlite.sqlite.DbCategoria;

public class FormActivity extends AppCompatActivity {
    EditText txtNombreCat;
    Button btn_Cat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        txtNombreCat = findViewById(R.id.txtNombreCat);
        btn_Cat = findViewById(R.id.btn_cat);

        btn_Cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = txtNombreCat.getText().toString();
                Categoria c = new Categoria(nombre);
                DbCategoria db = new DbCategoria(getApplicationContext());
                long id = db.insertarCategoria(c);

                if(id > 0){
                    Toast.makeText(FormActivity.this, "Categoria guardada", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(FormActivity.this, "Error al insertar", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}