package com.frutagolosa.fgadm.model;


import com.google.gson.annotations.SerializedName;

public class Contact {

    @SerializedName("ID_PEDIDO")
    private String ID_PEDIDO;

    @SerializedName("fecha_pedido")
    private String fecha_pedido;

    @SerializedName("telefono_cliente")
    private String telefono_cliente;

    @SerializedName("nombre_cliente")
    private String nombre_cliente;

    @SerializedName("correo_cliente")
    private String correo_cliente;

    @SerializedName("nombre_qrecibe")
    private String nombre_qrecibe;

    @SerializedName("telefono_qrecibe")
    private String telefono_qrecibe;

    @SerializedName("fecha_entrega")
    private String fecha_entrega;

    @SerializedName("franja_horaria")
    private String franja_horaria;

    @SerializedName("calle_principal")
    private String calle_principal;

    @SerializedName("calle_secundaria")
    private String calle_secundaria;

    @SerializedName("casaempresaedificio")
    private String casaempresaedificio;

    @SerializedName("referencia")
    private String referencia;

    @SerializedName("nombre_arreglo")
    private String nombre_arreglo;

    @SerializedName("portada_tarjeta")
    private String portada_tarjeta;


    @SerializedName("texto_tarjeta")
    private String texto_tarjeta;

    @SerializedName("especificacion")
    private String  especificacion;

    @SerializedName("numeracion")
    private String numeracion;

    @SerializedName("disenador")
    private String disenador;

    @SerializedName("motorizado")
    private String motorizado;

    @SerializedName("estado")
    private String estado;

    @SerializedName("keyaccount")
    private String keyaccount;

    @SerializedName("parroquia")
    private String parroquia;

    @SerializedName("costo_envio")
    private String costo_envio;

    @SerializedName("regalo")
    private String regalo;

    @SerializedName("cd")
    private String cd;

    @SerializedName("globo")
    private String globo;

    @SerializedName("sector")
    private String sector;

    @SerializedName("coordenadas")
    private String coordenadas;

    @SerializedName("imagen")
    private String imagen;

    @SerializedName("imgal")
    private String imgal;

    @SerializedName("imgaent")
    private String imgaent;

    public String getID_PEDIDO() {
        return ID_PEDIDO;
    }

    public String getFecha_pedido() {
        return fecha_pedido;
    }

    public String getTelefono_cliente() {
        return telefono_cliente;
    }

    public String getNombreCliente() {
        return nombre_cliente;
    }


    public String getCorreo_cliente() {
        return correo_cliente;
    }
    public String getNombre_qRecibe() {
        return nombre_qrecibe;
    }

    public String getTelefono_qRecibe() {
        return telefono_qrecibe;
    }

    public String getFechaEntrega() {
        return fecha_entrega;
    }

    public String getFranja_horaria() {
        return franja_horaria;
    }
    public String getCalle_principal() {

        return calle_principal;
    }
    public String getCalle_secundaria() {
        return calle_secundaria;
    }
    public String getCasaempresaedificio() {

        return casaempresaedificio;
    }
    public String getReferencia() {
        return referencia;
    }

    public String getNombre_arreglo() {
        return nombre_arreglo;
    }
    public String getPortada_tarjeta() {
        return portada_tarjeta;
    }

    public String getTexto_tarjeta() {
        return texto_tarjeta;
    }

    public String getEspecificacion() {
        return especificacion;
    }

    public String getNumeracion() {
        return numeracion;
    }

    public String getDisenador() {
        return disenador;
    }

    public String getMotorizado() {
        return motorizado;
    }

    public String getEstado() {
        return estado;
    }

    public String getKeyaccount() {
        return keyaccount;
    }

    public String getParroquia() {
        return parroquia;
    }

    public String getCosto_envio() {
        return costo_envio;
    }


    public String regalo() {
        return regalo;
    }

    public String getcd() {
        return cd;
    }

    public String getGlobo() {
        return globo;
    }

    public String getSector() {
        return sector;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public String getimagen() {
        return imagen;
    }
    public String getimgal() {
        return imgal;
    }

    public String getImgaent() {
        return imgaent;
    }
}