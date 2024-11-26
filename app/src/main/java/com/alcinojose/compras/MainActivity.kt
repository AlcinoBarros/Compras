package com.alcinojose.compras

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var tarefasRecyclerview: RecyclerView
    private lateinit var adapter: ItemAdapter
    private lateinit var itemList: MutableList<Item>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        supportActionBar?.hide()

        itemList = ArrayList()
        initData()

        tarefasRecyclerview = findViewById(R.id.tarefasRecyclerView)
        tarefasRecyclerview.setLayoutManager( LinearLayoutManager(this))

        val fab: FloatingActionButton = findViewById(R.id.addTarefa)

        fab.setOnClickListener(View.OnClickListener(){
            val intent = Intent(this, NovaTarefa::class.java)
            startActivity(intent)
        })

//        fab.setOnClickListener(){
//            val intent = Intent(this, NovaTarefa::class.java)
//            startActivity(intent)
//        }

        adapter = ItemAdapter(itemList)
        tarefasRecyclerview.setAdapter(adapter)

    }
    
    private fun initData(){
        for (i in 1..20){
            itemList.add(Item("Titulo $i", "descricao $i"))
        }
    }


}