package com.gerard.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.gerard.sqlite.Models.Categoria;
import com.gerard.sqlite.Models.Producto;
import com.gerard.sqlite.Models.ProductoAdapter;
import com.gerard.sqlite.sqlite.DbCategoria;
import com.gerard.sqlite.sqlite.DbProducto;

import java.util.ArrayList;

public class ListadoActivity extends AppCompatActivity {
    ArrayList<Categoria>categorias = new ArrayList<>();
    Spinner spListadoProductos;
    RecyclerView recycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        recycler = findViewById(R.id.recycler);
        spListadoProductos = findViewById(R.id.spListadoProductos);

        recycler.setLayoutManager(new LinearLayoutManager(this));

        cargarCategorias();

        spListadoProductos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ArrayList<Producto>productosFiltrados = new ArrayList<>();
                Categoria c = (Categoria) spListadoProductos.getSelectedItem();
                for(Producto p : MainActivity.productos){
                    if(p.getCategoria().getId() == c.getId()){
                        productosFiltrados.add(p);
                    }
                }
                ProductoAdapter adapter = new ProductoAdapter(productosFiltrados);
                recycler.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                ProductoAdapter adapter1 = new ProductoAdapter(MainActivity.productos);
                recycler.setAdapter(adapter1);
            }
        });

    }

    public void cargarCategorias(){
        DbCategoria dbCategoria = new DbCategoria(this);
        categorias = dbCategoria.getCategorias();
        if(categorias != null){
            ArrayAdapter<Categoria> arrayAdapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_spinner_dropdown_item,categorias);
            spListadoProductos.setAdapter(arrayAdapter);
        }
    }

}