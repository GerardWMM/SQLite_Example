package com.gerard.sqlite.Models;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gerard.sqlite.R;
import com.gerard.sqlite.sqlite.DbCategoria;

import java.util.ArrayList;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolder>{
    ArrayList<Producto>productos;

    public ProductoAdapter(ArrayList<Producto>productos){
        this.productos = productos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.cargarInfo(productos.get(position));
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgProRecycler;
        TextView txt_nombrePro,txt_modeloPro,txt_marcaPro,txt_stockPro,txt_precioPro;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProRecycler = itemView.findViewById(R.id.imgProRecycler);
            txt_nombrePro = itemView.findViewById(R.id.nombrePro);
            txt_modeloPro = itemView.findViewById(R.id.modeloPro);
            txt_marcaPro = itemView.findViewById(R.id.marcaPro);
            txt_stockPro = itemView.findViewById(R.id.stockPro);
            txt_precioPro = itemView.findViewById(R.id.precioPro);
        }

        public void cargarInfo(Producto producto){
            String nombre = producto.getNombre();
            String modelo = producto.getModelo();
            String marca = producto.getMarca();
            String stock = String.valueOf(producto.getStock());
            String precio = String.valueOf(producto.getPrecio());
            String categoria = producto.getCategoria().getNombre();

            txt_nombrePro.setText(nombre);
            txt_modeloPro.setText(modelo);
            txt_marcaPro.setText(marca);
            txt_stockPro.setText(stock);
            txt_precioPro.setText(precio);

            switch(categoria){
                case "Computacion":
                    imgProRecycler.setImageResource(R.drawable.computadora);
                    break;
                case "Celulares":
                    imgProRecycler.setImageResource(R.drawable.celular);
                    break;
                case "Calzado":
                    imgProRecycler.setImageResource(R.drawable.calzado);
                    break;
                case "Ropa":
                    imgProRecycler.setImageResource(R.drawable.ropa);
                    break;
            }
        }
    }
}
