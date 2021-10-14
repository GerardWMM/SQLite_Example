package com.gerard.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.gerard.sqlite.Models.Categoria;
import com.gerard.sqlite.Models.Producto;
import com.gerard.sqlite.sqlite.DbCategoria;
import com.gerard.sqlite.sqlite.DbProducto;

import java.util.ArrayList;

public class FormProducto extends AppCompatActivity {
    EditText txtNombrePro,txtMarcaPro,txtModeloPro,txtPrecioPro,txtStockPro;
    Spinner spCat;
    Button btnPro;

    public void cargarSpinner(){
        DbCategoria db = new DbCategoria(this);
        ArrayList<Categoria> categorias = db.getCategorias();
        if(categorias != null){
            ArrayAdapter<Categoria> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_spinner_dropdown_item, categorias );
            spCat.setAdapter(adapter);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_producto);

        txtNombrePro = findViewById(R.id.nombrePro);
        txtMarcaPro = findViewById(R.id.txtMarcaPro);
        txtModeloPro = findViewById(R.id.txtModeloPro);
        txtPrecioPro = findViewById(R.id.txtPrecioPro);
        txtStockPro = findViewById(R.id.txtStockPro);
        spCat = findViewById(R.id.spCat);
        btnPro = findViewById(R.id.btnGuardarPro);
        cargarSpinner();


        btnPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = txtNombrePro.getText().toString();
                String marca = txtMarcaPro.getText().toString();
                String modelo = txtModeloPro.getText().toString();
                int precio = Integer.parseInt(txtPrecioPro.getText().toString());
                int stock =  Integer.parseInt(txtStockPro.getText().toString());
                Categoria categoria = (Categoria) spCat.getSelectedItem();

                Producto p = new Producto(nombre,marca,modelo,stock,precio,categoria);

                DbProducto db = new DbProducto(getApplicationContext());

                long id = db.insertarProducto(p);
                if( id >= 0 ){
                    Toast.makeText(FormProducto.this,
                            nombre+" insertado", Toast.LENGTH_LONG).show();
                    limpiarCampos();
                }else{
                    Toast.makeText(FormProducto.this,
                            "Error al insertar", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void limpiarCampos(){
        txtNombrePro.setText("");
        txtMarcaPro.setText("");
        txtModeloPro.setText("");
        txtPrecioPro.setText("");
        txtStockPro.setText("");
        spCat.setSelection(0);
    }
}