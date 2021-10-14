package com.gerard.sqlite.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.gerard.sqlite.Models.Categoria;
import com.gerard.sqlite.Models.Producto;

import java.util.ArrayList;

public class DbProducto extends DbHelper{
    Context context;

    public DbProducto(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarProducto(Producto producto){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase(); //db va a leer la base con la que se trabajará

        long res = 0; //Respuesta que proviene desde la bd, generalmente es de tipo long

        ContentValues valores = new ContentValues();
        valores.put("nombre",producto.getNombre());
        valores.put("marca",producto.getMarca());
        valores.put("modelo",producto.getModelo());
        valores.put("stock",producto.getStock());
        valores.put("precio",producto.getPrecio());
        valores.put("categoria",producto.getCategoria().getId());

        res = db.insert(dbHelper.TABLE_PRODUCTS,null,valores);
        return res;
    }

    public ArrayList<Producto> getProductos(){
        DbHelper helper = new DbHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();

        ArrayList<Producto> productos = new ArrayList<>();
        Cursor cursor = null; //Es un tipo de colección donde se guardan los registros de la bd
        Producto producto = null;
        DbCategoria dbCat = new DbCategoria(context);

        cursor = db.rawQuery("SELECT * FROM "+DbHelper.TABLE_PRODUCTS,null);

        if(cursor.moveToFirst()){
            do{
                Categoria cat = dbCat.getCategoria(cursor.getInt(6));
                producto = new Producto(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getInt(4),
                        cursor.getInt(5),
                        cat);


                productos.add(producto);
            }while(cursor.moveToNext());
        }

        return productos;
    }

    public int actualizarProducto(int id,String nombre, String marca, String modelo,int stock){
        DbHelper helper = new DbHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nombre",nombre);
        values.put("marca",marca);
        values.put("modelo",modelo);
        values.put("stock",stock);


        int resultado = db.update(TABLE_PRODUCTS,values,"id = ?",new String[]{String.valueOf(id)});
        return resultado;
    }


    public int eliminarProducto(int id){
        DbHelper helper = new DbHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();

        int res = db.delete(TABLE_PRODUCTS,"id = ?",new String[]{String.valueOf(id)});
        return res;
    }

}