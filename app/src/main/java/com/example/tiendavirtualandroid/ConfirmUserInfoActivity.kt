package com.example.tiendavirtualandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ConfirmUserInfoActivity : AppCompatActivity() {

    private lateinit var name : EditText
    private lateinit var email : EditText
    private lateinit var phone : EditText
    private lateinit var address : EditText
    private lateinit var city : EditText
    private lateinit var btnConfirmPurchase : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_user_info)

        btnConfirmPurchase.setOnClickListener {
            name.text.toString()
        }
    }
}