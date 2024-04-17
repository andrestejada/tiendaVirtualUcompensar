package com.example.tiendavirtualandroid

import ProductoProvider
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tiendavirtualandroid.adapter.ProductAdapter

class ProductListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)
        initRecicleView()
    }
    fun initRecicleView(){
        val recicyleView = findViewById<RecyclerView>(R.id.product_card_layout)
        recicyleView.layoutManager = LinearLayoutManager(this)
        recicyleView.adapter = ProductAdapter(ProductoProvider.productosList)
    }
}