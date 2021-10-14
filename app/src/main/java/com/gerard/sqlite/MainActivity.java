package com.gerard.sqlite;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.gerard.sqlite.Models.Producto;
import com.gerard.sqlite.sqlite.DbProducto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<Producto>productos;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);

        startActivity(new Intent(this,ListadoActivity.class));

        DbProducto db = new DbProducto(this);
        productos = db.getProductos();

        if(productos != null){
            ArrayAdapter<Producto> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_spinner_dropdown_item,productos );
            spinner.setAdapter(adapter);
        }

    }
}