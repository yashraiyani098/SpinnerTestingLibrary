package com.ext.spinnertesting

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ext.searchablespinnerview.SearchableSpinnerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize SearchableSpinnerView
        val searchableSpinner = findViewById<SearchableSpinnerView>(R.id.searchableSpinner)
        val items = listOf("lion", "leopard", "buffalo", "cow", "dog")
        searchableSpinner.setItems(items)
        searchableSpinner.setOnItemSelectedListener { selectedItem ->
            // Handle item selection
            println("Selected item: $selectedItem")
        }
    }
}