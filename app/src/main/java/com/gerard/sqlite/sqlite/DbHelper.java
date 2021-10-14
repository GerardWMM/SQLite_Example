package com.gerard.sqlite.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "tienda_bd"; //Constante correspondiente al nombre de la BD
    public static final int DB_VERSION = 3; //Corresponde a la version de la BD

    public static final String TABLE_PRODUCTS = "Productos"; //Tabla. Se usa para poder realizar mejores consultas
    public static final String TABLE_CATEGORIES = "Categorias";
    public static final String TABLE_USERS = "Usuarios";


    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //crear las tablas
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_CATEGORIES+" ("+"" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nombre TEXT NOT NULL)");


        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_PRODUCTS+" ("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nombre TEXT NOT NULL,"+
                "marca TEXT NOT NULL,"+
                "modelo TEXT NOT NULL,"+
                "stock INTEGER NOT NULL,"+
                "precio INTEGER NOT NULL,"+
                "categoria INTEGER NOT NULL,"+
                "FOREIGN KEY (categoria) REFERENCES TABLE_CATEGORIES(id))");

        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_USERS+" ("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nombres TEXT NOT NULL,"+
                "apellidos TEXT NOT NULL,"+
                "email TEXT NOT NULL,"+
                "clave TEXT NOT NULL,"+
                "tipo TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //Este metodo se llama cuando hay una version de la bd
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_PRODUCTS); //Borra la tabla en caso de que exista
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_CATEGORIES);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_USERS);
        onCreate(sqLiteDatabase); //Llama al metodo onCreate para volver a crear la tabla
    }
}
