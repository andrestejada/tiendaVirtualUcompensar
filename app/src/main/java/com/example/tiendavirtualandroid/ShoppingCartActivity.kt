package com.example.tiendavirtualandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tiendavirtualandroid.adapter.ShoppingCartAdapter
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.google.firebase.database.getValue

class ShoppingCartActivity : AppCompatActivity() {
    private var database: DatabaseReference = Firebase.database.reference
    private var productArrayList = ArrayList<Producto>()
    private lateinit var auth: FirebaseAuth
    private lateinit var recicyleView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        setContentView(R.layout.activity_shopping_cart)
        initRecicleView()
    }

    private fun onDeleteItem(position: Int) {
        productArrayList.removeAt(position)
        recicyleView.adapter?.notifyItemRemoved(position)
    }

    fun initRecicleView() {
        val currentUser = auth.currentUser
        recicyleView = findViewById<RecyclerView>(R.id.shopping_cart_recycle)
        recicyleView.layoutManager = LinearLayoutManager(this)
        database.child("shoppingCart").child(currentUser?.uid!!)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    productArrayList.clear()
                    for (productSnapshot in dataSnapshot.children) {
                        if (productSnapshot.exists()) {
                            var item = productSnapshot.getValue(Producto::class.java)

                            Log.w("ShoppingCartActivity", productSnapshot?.key!!)
                            item?.id = productSnapshot?.key!!
                            productArrayList.add(item!!)

                        }

                    }
                    recicyleView.adapter =
                        ShoppingCartAdapter(
                            productArrayList,
                            currentUser!!,
                            onClickDelete = { position -> onDeleteItem(position) })
                }

                override fun onCancelled(error: DatabaseError) {
                    // Failed to read value
                    Log.w("TAG", "Failed to read value.", error.toException())
                }
            })

    }
}