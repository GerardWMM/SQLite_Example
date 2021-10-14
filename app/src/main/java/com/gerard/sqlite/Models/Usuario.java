package com.gerard.sqlite.Models;

public class Usuario {
    private int id;
    private String nombres;
    private String apellidos;
    private String email;
    private String clave;
    private String tipo;

    public Usuario(){
    }

    public Usuario(String nombres, String apellidos, String email, String clave, String tipo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.clave = clave;
        this.tipo = tipo;
    }

    public Usuario(int id, String nombres, String apellidos, String email, String clave, String tipo) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.clave = clave;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public String getClave() {
        return clave;
    }

    public String getTipo() {
        return tipo;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
