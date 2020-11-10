package com.example.comprasapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.comprasapp.Entidades.EntMarca;
import com.example.comprasapp.Utilidades.Utilidades;

import java.util.ArrayList;

public class ListaMarca extends AppCompatActivity {
    ArrayList<EntMarca> listMarca;
    RecyclerView recycler;
    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_marca);
        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_marca",null,1);
        listMarca = new ArrayList<>();
        recycler=(RecyclerView)findViewById(R.id.recyclerMarca);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        consultarListamarca();

        ListaMarcaAdapter adapter = new ListaMarcaAdapter(listMarca);
        recycler.setAdapter(adapter);
    }
    private void consultarListamarca(){
        SQLiteDatabase db = conn.getReadableDatabase();
        EntMarca marca = null;
        Cursor cursor = db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_MARCA, null);
        while (cursor.moveToNext()){
            marca = new EntMarca();

            marca.setId(cursor.getString(0));
            marca.setDescripcion(cursor.getString(1));
            listMarca.add(marca);
        }
    }
}