package com.example.comprasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.comprasapp.Utilidades.Utilidades;


public class Marca extends AppCompatActivity {
    EditText campoDescripcion, busID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marca);

        campoDescripcion = (EditText) findViewById(R.id.campoDescripcion);
        busID = (EditText) findViewById(R.id.busID);

    }

    public void onClick(View view) {

        Intent miIntent = null;

        switch (view.getId()) {

            case R.id.listmarca:
                miIntent = new Intent(Marca.this, ListaMarca.class);
                break;


        }
        startActivity(miIntent);

    }


    public void onClickw(View view) {
        final String alerta = campoDescripcion.getText().toString();
        if (alerta.length() == 0) {
            campoDescripcion.requestFocus();
            campoDescripcion.setError("Ingrese Descripcion");
        } else {

            regrado();

            campoDescripcion.getText().clear();
            Intent miIntent= new Intent(Marca.this,ListaMarca.class);
            startActivity(miIntent);
        }
    }


    public void onClickbuscar(View view) {
        final String alerta = busID.getText().toString();
        if (alerta.length() == 0) {
            busID.requestFocus();
            busID.setError("Ingrese Codigo a Buscar");
        } else {

            busGrado();

        }
    }

    public void onCliceditar(View view) {
        final String alerta = campoDescripcion.getText().toString();
        if (alerta.length() == 0) {
            campoDescripcion.requestFocus();
            campoDescripcion.setError("Busque La Marca a Editar");
        } else {

            Editargra();
            campoDescripcion.getText().clear();
            busID.getText().clear();
            Intent miIntent= new Intent(Marca.this,ListaMarca.class);
            startActivity(miIntent);


        }
    }

    public void onCliceliminar(View view) {
        final String alerta = campoDescripcion.getText().toString();
        if (alerta.length() == 0) {
            campoDescripcion.requestFocus();
            campoDescripcion.setError("Busque La Marca a Eliminar");
        } else {

            Eliminargra();
            campoDescripcion.getText().clear();
            busID.getText().clear();
            Intent miIntent= new Intent(Marca.this,ListaMarca.class);
            startActivity(miIntent);

        }
    }

    public void regrado() {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_marca", null, 1);

        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Utilidades.MARCA_DESCRIPCION, campoDescripcion.getText().toString());


        Long idResultant = db.insert(Utilidades.TABLA_MARCA, Utilidades.MARCA_ID, values);

        Toast.makeText(getApplicationContext(), "REGISTRO DE MARCA:" + idResultant, Toast.LENGTH_LONG).show();


    }



    public void busGrado () {

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_marca", null, 1);
        SQLiteDatabase db = conn.getReadableDatabase();

        String[] parametros = {busID.getText().toString()};

        try {
            Cursor cursor = db.rawQuery("SELECT "+ Utilidades.MARCA_DESCRIPCION +  " FROM " + Utilidades.TABLA_MARCA + " WHERE " + Utilidades.MARCA_ID + "=? ", parametros);


            cursor.moveToFirst();


            campoDescripcion.setText(cursor.getString(0));


        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Marca no Registrada", Toast.LENGTH_LONG).show();
        }
    }

    public void Editargra() {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_marca", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();
        String[] parametros = {busID.getText().toString()};
        ContentValues values = new ContentValues();
        values.put(Utilidades.MARCA_DESCRIPCION, campoDescripcion.getText().toString());


        db.update(Utilidades.TABLA_MARCA, values, Utilidades.MARCA_ID + "=?", parametros);

        Toast.makeText(getApplicationContext(), "Marca Actualizada", Toast.LENGTH_LONG).show();
        db.close();


    }
    public void Eliminargra(){
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_marca", null, 1);
        SQLiteDatabase db= conn.getWritableDatabase();
        String[] parametros = {busID.getText().toString()};
        db.delete(Utilidades.TABLA_MARCA,Utilidades.MARCA_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(), " Se ha Eliminado la Marca",Toast.LENGTH_LONG).show();
        db.close();



    }




}