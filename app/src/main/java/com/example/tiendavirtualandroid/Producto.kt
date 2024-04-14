package com.example.tiendavirtualandroid

data class Producto(
    val id: String,
    val titulo: String,
    val precio: Int,
    val descripcion: String,
    val marca: String,
    val imagenUrl: String,
    val unidades: Int
)