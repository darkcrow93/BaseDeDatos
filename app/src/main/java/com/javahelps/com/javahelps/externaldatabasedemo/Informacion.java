package com.javahelps.com.javahelps.externaldatabasedemo;

import android.graphics.Bitmap;

public class Informacion {
    String numeroInfo;
    String nombreInfo;
    String primarioInfo;
    String secundarioInfo;
    Bitmap imagenInfo;
    Bitmap imagenInfoShiny;
    String AlturaPulgadas;
    String AlturaMetros;
    String PesoLbs;
    String PesoKg;
    String Especie;
    String Masculino;
    String Femenino;
    String HabilidadPrimario;
    String HabilidadSecundario;
    String HabilidadOculta;
    String GrupoHuevoPrimario;
    String GrupoHuevoSecundario;
    String Captura;
    String PuntosEsfuerzoP;
    String PuntosEsfuerzoS;
    String PuntosEsfuerzoT;
    String Pasos;
    String Felicidad;
    String Experiencia;

    public Informacion(String numero1, String nombre1, String primario1, String secundario1, Bitmap imagen1, Bitmap imagenInfoShiny1,
                       String AlturaPulgadas1, String AlturaMetros1, String PesoLbs1, String PesoKg1, String Especie1, String Masculino1,
                       String Femenino1, String HabilidadPimario1, String HabilidadSecundario1, String HabilidadOculta1, String GrupoHuevoPrimario1,
                       String GrupoHuevoSecundario1, String Captura1, String PuntosEsfuerzoP1, String PuntosEsfuerzoS1, String PuntosEsfuerzoT1,
                       String Pasos1, String Felicidad1, String Experiencia1)
    {
        this.numeroInfo = numero1;
        this.nombreInfo = nombre1;
        this.primarioInfo = primario1;
        this.secundarioInfo = secundario1;
        this.imagenInfo = imagen1;
        this.imagenInfoShiny = imagenInfoShiny1;
        this.AlturaPulgadas = AlturaPulgadas1;
        this.AlturaMetros = AlturaMetros1;
        this.PesoLbs = PesoLbs1;
        this.PesoKg = PesoKg1;
        this.Especie = Especie1;
        this.Masculino = Masculino1;
        this.Femenino = Femenino1;
        this.HabilidadPrimario = HabilidadPimario1;
        this.HabilidadSecundario = HabilidadSecundario1;
        this.HabilidadOculta = HabilidadOculta1;
        this.GrupoHuevoPrimario = GrupoHuevoPrimario1;
        this.GrupoHuevoSecundario = GrupoHuevoSecundario1;
        this.Captura = Captura1;
        this.PuntosEsfuerzoP = PuntosEsfuerzoP1;
        this.PuntosEsfuerzoS = PuntosEsfuerzoS1;
        this.PuntosEsfuerzoT = PuntosEsfuerzoT1;
        this.Pasos = Pasos1;
        this.Felicidad = Felicidad1;
        this.Experiencia = Experiencia1;
    }

    public String getNumeroInfo() {
        return this.numeroInfo;
    }

    public String getNombreInfo() {
        return this.nombreInfo;
    }

    public String getPrimarioInfo() {
        return primarioInfo;
    }

    public String getSecundarioInfo() {
        return secundarioInfo;
    }

    public Bitmap getImagenInfo() {
        return this.imagenInfo;
    }

    public Bitmap getImagenInfoShiny() {
        return imagenInfoShiny;
    }

    public String getAlturaPulgadas() {
        return AlturaPulgadas;
    }

    public String getAlturaMetros() {
        return AlturaMetros;
    }

    public String getPesoLbs() {
        return PesoLbs;
    }

    public String getPesoKg() {
        return PesoKg;
    }

    public String getEspecie() {
        return Especie;
    }

    public String getMasculino() {
        return Masculino;
    }

    public String getFemenino() {
        return Femenino;
    }

    public String getHabilidadPrimario() {
        return HabilidadPrimario;
    }

    public String getHabilidadSecundario() {
        return HabilidadSecundario;
    }

    public String getHabilidadOculta() {
        return HabilidadOculta;
    }

    public String getGrupoHuevoPrimario() {
        return GrupoHuevoPrimario;
    }

    public String getGrupoHuevoSecundario() {
        return GrupoHuevoSecundario;
    }

    public String getCaptura() {
        return Captura;
    }

    public String getPuntosEsfuerzoP() {
        return PuntosEsfuerzoP;
    }

    public String getPuntosEsfuerzoS() {
        return PuntosEsfuerzoS;
    }

    public String getPuntosEsfuerzoT() {
        return PuntosEsfuerzoT;
    }

    public String getPasos() {
        return Pasos;
    }

    public String getFelicidad() {
        return Felicidad;
    }

    public String getExperiencia() {
        return Experiencia;
    }
}
