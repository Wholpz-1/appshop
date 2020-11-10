package com.example.comprasapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.comprasapp.Entidades.EntMarca;
import com.example.comprasapp.Utilidades.Utilidades;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;



public class Producto extends AppCompatActivity {
    ArrayList<String> listma;
    ArrayList<EntMarca> listmarca;
    ConexionSQLiteHelper conn;
    AutoCompleteTextView complemarc;

    Button btnfoto;
    ImageView  preimg;


    EditText texnombre,camprepro,camprocan, busID;


    private static final int CAMERA_REQUEST = 200;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

        conn = new ConexionSQLiteHelper(getApplicationContext(), "bd_marca", null, 1);



        texnombre=(EditText) findViewById(R.id.texnombre);
        camprepro =(EditText) findViewById(R.id.camprepro);
        camprocan= (EditText)  findViewById(R.id.camprocan);
        busID = (EditText) findViewById(R.id.busID);
        btnfoto = (Button) findViewById(R.id.btnfoto);
        preimg = (ImageView) findViewById(R.id.preimg);
        complemarc = (AutoCompleteTextView) findViewById(R.id.complemarc);

        consultarlistamarca();
        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, listma);
        complemarc.setAdapter(adaptador);




    }

    public void onClick(View view) {

        Intent miIntent = null;

        switch (view.getId()) {

            case R.id.listins:
                miIntent = new Intent(Producto.this, ListaProducto.class);
                break;

        }
        startActivity(miIntent);

    }


    public void regpros() {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_marca", null, 1);

        SQLiteDatabase db = conn.getWritableDatabase();

        Bitmap image = ((BitmapDrawable)preimg.getDrawable()).getBitmap();
        byte[] data = getBitmapAsByteArray(image);
        ContentValues values = new ContentValues();


        values.put(Utilidades.PRODUC_NOMBRE, texnombre.getText().toString());
        values.put(Utilidades.PRODUC_PRECIO, camprepro.getText().toString());
        values.put(Utilidades.PROCUC_CANTIDAD, camprocan.getText().toString());
        values.put(Utilidades.PRODUC_MARCA, complemarc.getText().toString());
        values.put(Utilidades.PRODUC_IMG, data);



        Long idResultant = db.insert(Utilidades.TABLA_PRODUCTO, Utilidades.PRODUCTO_ID, values);

        Toast.makeText(getApplicationContext(), "REGISTRO DE PRODUCTO:" + idResultant, Toast.LENGTH_LONG).show();

    }


    public void onClickw(View view) {
        final String alerta21 = busID.getText().toString();
        if (alerta21.length() == 1) {
            busID.requestFocus();
            busID.setError("Este campo debe estar vacio");
        } else {
            final String alerta = texnombre.getText().toString();
            if (alerta.length() == 0) {
                texnombre.requestFocus();
                texnombre.setError("Ingrese Nombre del Producto");
            } else {
                final String alerta1 = camprepro.getText().toString();
                if (alerta1.length() == 0) {
                    camprepro.requestFocus();
                    camprepro.setError("Ingrese el Precio");
                } else {
                    final String alerta2 = camprocan.getText().toString();
                    if (alerta2.length() == 0) {
                        camprocan.requestFocus();
                        camprocan.setError("Ingrese la Cantidad de Producto");
                    } else {
                        final String alerta3 = complemarc.getText().toString();
                        if (alerta3.length() == 0) {
                            complemarc.requestFocus();
                            complemarc.setError("Ingrese la Marca");
                        } else {

                            regpros();

                            texnombre.getText().clear();
                            camprepro.getText().clear();
                            camprocan.getText().clear();
                            complemarc.getText().clear();

                            Intent miIntent = new Intent(Producto.this, ListaProducto.class);
                            startActivity(miIntent);

                        }
                    }
                }
            }
        }
    }


    public void onClickBuscar(View view) {
        final String alerta = busID.getText().toString();
        if (alerta.length() == 0) {
            busID.requestFocus();
            busID.setError("Debe insgresar un codigo");
        } else {


            BusInscrip();


        }
    }

    public void onClickEditar(View view) {
        final String alerta21 = busID.getText().toString();
        if (alerta21.length() == 0) {
            busID.requestFocus();
            busID.setError("Debe Buscar Primero");
        } else {
            final String alerta = texnombre.getText().toString();
            if (alerta.length() == 0) {
                texnombre.requestFocus();
                texnombre.setError("Ingrese Nombre del Producto");
            } else {
                final String alerta1 = camprepro.getText().toString();
                if (alerta1.length() == 0) {
                    camprepro.requestFocus();
                    camprepro.setError("Ingrese el Precio");
                } else {
                    final String alerta2 = camprocan.getText().toString();
                    if (alerta2.length() == 0) {
                        camprocan.requestFocus();
                        camprocan.setError("Ingrese la Cantidad de Producto");
                    } else {
                        final String alerta3 = complemarc.getText().toString();
                        if (alerta3.length() == 0) {
                            complemarc.requestFocus();
                            complemarc.setError("Ingrese la Marca");
                        } else {

                            Editarpro();
                            busID.getText().clear();
                            texnombre.getText().clear();
                            camprepro.getText().clear();
                            camprocan.getText().clear();
                            complemarc.getText().clear();

                            Intent miIntent = new Intent(Producto.this, ListaProducto.class);
                            startActivity(miIntent);

                        }
                    }
                }
            }
        }
    }

    public void onClickEliminar(View view) {
        final String alerta21 = busID.getText().toString();
        if (alerta21.length() == 0) {
            busID.requestFocus();
            busID.setError("Debe Buscar Primero");
        } else {
            final String alerta = texnombre.getText().toString();
            if (alerta.length() == 0) {
                texnombre.requestFocus();
                texnombre.setError("Ingrese Nombre del Producto");
            } else {
                final String alerta1 = camprepro.getText().toString();
                if (alerta1.length() == 0) {
                    camprepro.requestFocus();
                    camprepro.setError("Ingrese el Precio");
                } else {
                    final String alerta2 = camprocan.getText().toString();
                    if (alerta2.length() == 0) {
                        camprocan.requestFocus();
                        camprocan.setError("Ingrese la Cantidad de Producto");
                    } else {
                        final String alerta3 = complemarc.getText().toString();
                        if (alerta3.length() == 0) {
                            complemarc.requestFocus();
                            complemarc.setError("Ingrese la Marca");
                        } else {

                            Eliminarpro();

                            busID.getText().clear();
                            texnombre.getText().clear();
                            camprepro.getText().clear();
                            camprocan.getText().clear();
                            complemarc.getText().clear();

                            Intent miIntent = new Intent(Producto.this, ListaProducto.class);
                            startActivity(miIntent);

                        }
                    }
                }
            }
        }
    }



    public void BusInscrip() {

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_marca", null, 1);
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] parametros = {busID.getText().toString()};

        try {
            Cursor cursor = db.rawQuery("SELECT " + Utilidades.PRODUC_NOMBRE + "," + Utilidades.PRODUC_PRECIO + "," + Utilidades.PROCUC_CANTIDAD + "," + Utilidades.PRODUC_MARCA + " FROM " + Utilidades.TABLA_PRODUCTO + " WHERE " + Utilidades.PRODUCTO_ID + "=? ", parametros);


            cursor.moveToFirst();


            texnombre.setText(cursor.getString(0));
            camprepro.setText(cursor.getString(1));
            camprocan.setText(cursor.getString(2));
            complemarc.setText(cursor.getString(3));


        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Producto No Registrado", Toast.LENGTH_LONG).show();
        }
    }

    public void Editarpro() {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_marca", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();
        String[] parametros = {busID.getText().toString()};
        Bitmap image = ((BitmapDrawable)preimg.getDrawable()).getBitmap();
        byte[] data = getBitmapAsByteArray(image);
        ContentValues values = new ContentValues();

        values.put(Utilidades.PRODUC_NOMBRE, texnombre.getText().toString());
        values.put(Utilidades.PRODUC_PRECIO, camprepro.getText().toString());
        values.put(Utilidades.PROCUC_CANTIDAD, camprocan.getText().toString());
        values.put(Utilidades.PRODUC_MARCA, complemarc.getText().toString());
        values.put(Utilidades.PRODUC_IMG, data);



        db.update(Utilidades.TABLA_PRODUCTO, values, Utilidades.PRODUCTO_ID + "=?", parametros);

        Toast.makeText(getApplicationContext(), " Producto Actualizado", Toast.LENGTH_LONG).show();
        db.close();


    }

    public void Eliminarpro() {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_marca", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();
        String[] parametros = {busID.getText().toString()};
        db.delete(Utilidades.TABLA_PRODUCTO, Utilidades.PRODUCTO_ID + "=?", parametros);
        Toast.makeText(getApplicationContext(), " Se ha Eliminado el Producto", Toast.LENGTH_LONG).show();
        db.close();


    }

    private void consultarlistamarca() {
        SQLiteDatabase db = conn.getReadableDatabase();

        EntMarca marca = null;
        listmarca = new ArrayList<EntMarca>();

        Cursor cursor = db.rawQuery("SELECT " + Utilidades.MARCA_DESCRIPCION + " FROM " + Utilidades.TABLA_MARCA, null);


        while (cursor.moveToNext()) {
            marca = new EntMarca();
            marca.setDescripcion(cursor.getString(0));




            listmarca.add(marca);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listma = new ArrayList<String>();

        for (int i = 0; i < listmarca.size(); i++) {
            listma.add(listmarca.get(i).getDescripcion());
        }
    }

    public void abrircamara(View view){

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivityForResult(intent, CAMERA_REQUEST);
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CAMERA_REQUEST && resultCode == RESULT_OK){

            Bundle extras = data.getExtras();
            Bitmap image = (Bitmap)extras.get("data");
            preimg.setImageBitmap(image);

        }

    }
    public static byte[] getBitmapAsByteArray(Bitmap bitmap) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        return outputStream.toByteArray();
    }






}


