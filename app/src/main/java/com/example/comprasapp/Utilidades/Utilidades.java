package com.example.comprasapp.Utilidades;

public class Utilidades {

    public static final String TABLA_MARCA="marca";
    public static final String MARCA_ID="id";
    public static final String MARCA_DESCRIPCION="descripcion";

    public static final String CREAR_TABLA_MARCA =" CREATE TABLE " + TABLA_MARCA + " (" + MARCA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + MARCA_DESCRIPCION + " TEXT)";

    public static final String TABLA_PRODUCTO="producto";
    public static final String PRODUCTO_ID="id";
    public static final String PRODUC_NOMBRE="nombre";
    public static final String PRODUC_PRECIO="precio";
    public static final String PROCUC_CANTIDAD="cantidad";
    public static final String PRODUC_MARCA = "pmarca";
    public static final String PRODUC_IMG = "proimg";

    public static final String CREAR_TABLA_PRODUCTO =" CREATE TABLE " + TABLA_PRODUCTO + " (" + PRODUCTO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PRODUC_NOMBRE + " TEXT," + PRODUC_PRECIO + " TEXT,"  + PROCUC_CANTIDAD + " TEXT," + PRODUC_MARCA + " TEXT, " + PRODUC_IMG +" BLOB)";


}
