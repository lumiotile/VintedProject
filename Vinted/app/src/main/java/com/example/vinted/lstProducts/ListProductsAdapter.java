package com.example.vinted.lstProducts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vinted.R;
import com.example.vinted.beans.Producto;

import java.util.ArrayList;

public class ListProductsAdapter extends RecyclerView.Adapter<ListProductsAdapter.ContactViewHolder> {

    ArrayList<Producto> listaProductos;

    public ListProductsAdapter(ArrayList<Producto> listaProductos){
        this.listaProductos = listaProductos;
    }
    @NonNull
    @Override
    public ListProductsAdapter.ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_product_element, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListProductsAdapter.ContactViewHolder holder, int position) {
        holder.viewNombre.setText(listaProductos.get(position).getNombre());
        holder.viewPrecio.setText(String.valueOf(listaProductos.get(position).getPrecio()));
        holder.viewDescripcion.setText(listaProductos.get(position).getDescripcion());
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView viewNombre, viewDescripcion, viewPrecio;
        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);

            viewNombre = itemView.findViewById(R.id.nombreView);
            viewDescripcion = itemView.findViewById(R.id.descipcionView);
            viewPrecio = itemView.findViewById(R.id.precioView);
        }
    }
}
