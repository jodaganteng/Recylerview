package com.example.recylerview

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter
    private val itemList = mutableListOf<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        val addButton: Button = findViewById(R.id.addButton)

        adapter = ItemAdapter(itemList)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Menambahkan beberapa item statis
        itemList.add(Item("Item 1", "Deskripsi item 1"))
        itemList.add(Item("Item 2", "Deskripsi item 2"))
        adapter.notifyDataSetChanged()

        addButton.setOnClickListener {
            addNewItem()
        }
    }

    private fun addNewItem() {
        val newItemNumber = itemList.size + 1
        val newItem = Item("Item $newItemNumber", "Deskripsi item $newItemNumber")
        adapter.addItem(newItem)
        recyclerView.scrollToPosition(itemList.size - 1)
    }
}