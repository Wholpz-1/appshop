package com.example.comprasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {

        Intent miIntent = null;

        switch (view.getId()) {
            case R.id.idmarca:
                miIntent = new Intent(MainActivity.this, Marca.class);
                break;
            case R.id.idproducto:
                miIntent = new Intent(MainActivity.this, Producto.class);

                break;
            case R.id.idlistpro:
                miIntent = new Intent(MainActivity.this,ListaProducto.class);
                break;
            case R.id.idlistmar:
                miIntent = new Intent(MainActivity.this,ListaMarca.class);
                break;
        }
        startActivity(miIntent);
    }
}