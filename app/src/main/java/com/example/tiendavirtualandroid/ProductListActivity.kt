package com.example.tiendavirtualandroid

import ProductoProvider
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tiendavirtualandroid.adapter.ProductAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProductListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)
        initRecicleView()

        val floatingBtn = findViewById<FloatingActionButton>(R.id.fab_cart)
        floatingBtn.setOnClickListener {
            val intent = Intent(this,ShoppingCartActivity::class.java)
            startActivity(intent)
        }
    }
    fun initRecicleView(){
        val recicyleView = findViewById<RecyclerView>(R.id.product_card_layout)
        recicyleView.layoutManager = LinearLayoutManager(this)
        recicyleView.adapter = ProductAdapter(ProductoProvider.productosList)
    }
}