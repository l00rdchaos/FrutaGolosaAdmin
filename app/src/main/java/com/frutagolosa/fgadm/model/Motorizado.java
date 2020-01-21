package com.frutagolosa.fgadm.model;

import com.google.gson.annotations.SerializedName;

public class Motorizado {

    @SerializedName("id")
    private String id;

    @SerializedName("telefono")
    private String telefono;

    @SerializedName("nombre")
    private String nombre;

    @SerializedName("correo")
    private String correo;

    @SerializedName("ubicacion")
    private String ubicacion;

    @SerializedName("coordenadas")
    private String coordenadas;

    public String getId() {
        return id;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

}


