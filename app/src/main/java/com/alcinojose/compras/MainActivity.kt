package com.alcinojose.compras

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        actionBar?.hide()
        setupButton()

        }

    private fun setupButton() {
        button = findViewById(R.id.btn_login)

        button.setOnClickListener {

            handleButtonClick()

        }

    }

    private fun handleButtonClick() {
        val intent = Intent(applicationContext, LoginActivity::class.java)
        startActivity(intent)

    }
}