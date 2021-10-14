package com.gerard.sqlite.Models;

public class Producto {
    private int id;
    private String nombre;
    private String marca;
    private String modelo;
    private int stock;
    private int precio;
    private Categoria categoria;

    public Producto() {

    }

    //Constructor para crear nuevos productos
    public Producto(String nombre, String marca, String modelo, int stock, int precio, Categoria categoria) {
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.stock = stock;
        this.precio = precio;
        this.categoria = categoria;
    }

    //Constructor para obtener productos
    public Producto(int id, String nombre, String marca, String modelo, int stock, int precio, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.stock = stock;
        this.precio = precio;
        this.categoria = categoria;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getStock() {
        return stock;
    }

    public int getPrecio(){
        return precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return this.nombre + " - " + this.marca;
    }


}
