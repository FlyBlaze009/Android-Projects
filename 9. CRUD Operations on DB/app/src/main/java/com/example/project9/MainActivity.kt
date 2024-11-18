package com.example.project9

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var itemNameEditText: EditText
    private lateinit var listView: ListView
    private lateinit var itemList: ArrayList<String>
    private lateinit var arrayAdapter: ArrayAdapter<String>
    private var selectedItemId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize database helper
        databaseHelper = DatabaseHelper(this)

        // Initialize views
        itemNameEditText = findViewById(R.id.itemNameEditText)
        listView = findViewById(R.id.itemListView)

        itemList = ArrayList(databaseHelper.getItems())
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, itemList)
        listView.adapter = arrayAdapter

        // Add item
        findViewById<Button>(R.id.addButton).setOnClickListener {
            val name = itemNameEditText.text.toString()
            if (name.isNotEmpty()) {
                databaseHelper.addItem(name)
                updateList()
                itemNameEditText.text.clear()
            }
        }

        // Update item
        findViewById<Button>(R.id.updateButton).setOnClickListener {
            val name = itemNameEditText.text.toString()
            selectedItemId?.let {
                if (name.isNotEmpty()) {
                    databaseHelper.updateItem(it, name)
                    updateList()
                    itemNameEditText.text.clear()
                }
            }
        }

        // Delete item
        findViewById<Button>(R.id.deleteButton).setOnClickListener {
            selectedItemId?.let {
                databaseHelper.deleteItem(it)
                updateList()
                itemNameEditText.text.clear()
            }
        }

        // Handle item click to select item for update or delete
        listView.setOnItemClickListener { _, _, position, _ ->
            itemNameEditText.setText(itemList[position])
            selectedItemId = position + 1 // assuming item ID starts from 1
        }
    }

    private fun updateList() {
        itemList.clear()
        itemList.addAll(databaseHelper.getItems())
        arrayAdapter.notifyDataSetChanged()
    }
}
