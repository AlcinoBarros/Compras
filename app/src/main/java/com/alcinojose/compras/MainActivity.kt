package com.alcinojose.compras

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alcinojose.compras.Model.AdicionarItemFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var tarefasRecyclerview: RecyclerView;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        supportActionBar?.hide();

        tarefasRecyclerview = findViewById(R.id.tarefasRecyclerView)
        tarefasRecyclerview.setLayoutManager( LinearLayoutManager(this));

        val fab: FloatingActionButton = findViewById(R.id.addTarefa)

        fab.setOnClickListener{
            val intent = Intent(this, AdicionarItemFragment::class.java)
            startActivity(intent)
        }

    }


}