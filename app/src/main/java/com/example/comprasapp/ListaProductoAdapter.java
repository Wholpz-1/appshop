package com.example.comprasapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.comprasapp.Entidades.EntProducto;

import java.util.ArrayList;

public class ListaProductoAdapter extends RecyclerView.Adapter<ListaProductoAdapter.ViewHolderDatos> {
    ArrayList<EntProducto> listPro;
    public ListaProductoAdapter(ArrayList<EntProducto>listProduct){
        this.listPro = listProduct;
    }
    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from((parent.getContext())).inflate(R.layout.itemproducto,null,false);

        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.itemproid.setText(listPro.get(position).getId());
        holder.itempronombre.setText(listPro.get(position).getNombre());
        holder.itempropre.setText(listPro.get(position).getPrecio());
        holder.itemprocan.setText(listPro.get(position).getCantidad());
        holder.itempromar.setText(listPro.get(position).getPmarca());
        Glide.with(holder.imgpro.getContext()).load(listPro.get(position).getProimg()).into(holder.imgpro);

    }

    @Override
    public int getItemCount() {
        return listPro.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        ImageView imgpro;
        TextView itemproid, itempronombre, itempropre, itemprocan, itempromar;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            itemproid = (TextView) itemView.findViewById(R.id.itemproid);
            itempronombre = ( TextView) itemView.findViewById(R.id.itempronombre);
            itempropre = (TextView) itemView.findViewById(R.id.itempropre);
            itemprocan = (TextView) itemView.findViewById(R.id.itemprocan);
            itempromar = (TextView) itemView.findViewById(R.id.itempromar);
            imgpro = (ImageView) itemView.findViewById(R.id.imgpro);

        }
    }
}
