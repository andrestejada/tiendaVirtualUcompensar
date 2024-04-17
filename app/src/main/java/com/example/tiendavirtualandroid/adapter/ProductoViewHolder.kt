package com.example.tiendavirtualandroid.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.tiendavirtualandroid.Producto
import com.example.tiendavirtualandroid.R

class ProductoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val name = view.findViewById<TextView>(R.id.product_title)
    val description = view.findViewById<TextView>(R.id.product_description)
    fun render(producto: Producto){
        name.text = producto.titulo;
        description.text = producto.descripcion
    }
}