package com.javahelps.com.javahelps.externaldatabasedemo;

import android.graphics.Bitmap;

public class Pokemon {
    String numero;
    String nombre;
    String primario;
    String secundario;
    Bitmap imagen;

    public Pokemon(String numero1, String nombre1, Bitmap imagen1, String primario1, String secundario1)
    {
        this.numero = numero1;
        this.nombre = nombre1;
        this.primario = primario1;
        this.secundario = secundario1;
        this.imagen = imagen1;
    }

    public String getNumero() {
        return this.numero;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getTipoP() {
        return this.primario;
    }

    public String getTipoS() {
        return this.secundario;
    }

    public Bitmap getImagen() {
        return this.imagen;
    }
}
