package com.example.comprasapp.Entidades;

public class EntProducto {
    private String id;
    private String nombre;
    private String precio;
    private String cantidad;
    private String pmarca;
    private byte [] proimg;

    public EntProducto() {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.pmarca = pmarca;
        this.proimg = proimg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPmarca() {
        return pmarca;
    }

    public void setPmarca(String pmarca) {
        this.pmarca = pmarca;
    }

    public byte[] getProimg() {
        return proimg;
    }

    public byte[] setProimg(byte[] proimg) {
        this.proimg = proimg;
        return proimg;
    }
}
