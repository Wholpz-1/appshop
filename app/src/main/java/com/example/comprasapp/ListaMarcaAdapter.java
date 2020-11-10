package com.example.comprasapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comprasapp.Entidades.EntMarca;

import java.util.ArrayList;

public class ListaMarcaAdapter extends RecyclerView.Adapter<ListaMarcaAdapter.ViewHolderDatos> {
    ArrayList<EntMarca> listMarca;
    public ListaMarcaAdapter(ArrayList<EntMarca>listMarca){
        this.listMarca = listMarca;
    }
    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from((parent.getContext())).inflate(R.layout.itemmarca, null, false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.itemmarcaid.setText(listMarca.get(position).getId());
        holder.itemmarcadescripcion.setText(listMarca.get(position).getDescripcion());

    }

    @Override
    public int getItemCount() {
        return listMarca.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView itemmarcaid, itemmarcadescripcion;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            itemmarcaid = (TextView) itemView.findViewById(R.id.itemmarcaid);
            itemmarcadescripcion = (TextView) itemView.findViewById(R.id.itemmarcadescripcion);
        }
    }
}
