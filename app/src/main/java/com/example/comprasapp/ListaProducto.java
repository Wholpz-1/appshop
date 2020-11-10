package com.example.comprasapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.os.Bundle;


import com.example.comprasapp.Entidades.EntProducto;
import com.example.comprasapp.Utilidades.Utilidades;

import java.util.ArrayList;

public class ListaProducto extends AppCompatActivity {
    ArrayList<EntProducto> listPro;
    RecyclerView recycler;
    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_producto);

        conn = new ConexionSQLiteHelper(getApplicationContext(),"bd_marca", null, 1);
        listPro=new ArrayList<>();

        recycler=(RecyclerView) findViewById(R.id.recyclerProducto);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        consultarlistapro();

        ListaProductoAdapter adapter = new ListaProductoAdapter(listPro);
        recycler.setAdapter(adapter);
    }
    private void consultarlistapro(){

        SQLiteDatabase db = conn.getReadableDatabase();

        EntProducto marca = null;

        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_PRODUCTO, null);

        while (cursor.moveToNext()){
            marca = new EntProducto();

            marca.setId(cursor.getString(0));
            marca.setNombre(cursor.getString(1));
            marca.setPrecio(cursor.getString(2));
            marca.setCantidad(cursor.getString(3));
            marca.setPmarca(cursor.getString(4));
            byte[] imgBytes = marca.setProimg(cursor.getBlob(5));
            BitmapFactory.decodeByteArray(imgBytes,0,imgBytes.length);


            listPro.add(marca);


        }
    }
}