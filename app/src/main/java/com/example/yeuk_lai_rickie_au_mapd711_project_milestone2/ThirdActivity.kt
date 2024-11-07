package com.example.yeuk_lai_rickie_au_mapd711_project_milestone2

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.SharedPreferences
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner

class ThirdActivity : AppCompatActivity() {

    private var items = arrayOf("iPhone 16 Pro", "iPhone 16", "iPhone 15", "iPhone 14", "iPhone SE")
    private var prices = arrayOf("$999", "$799", "$699", "$599", "$429")

    private lateinit var sharedPreferences: SharedPreferences


    // Key for saving selection in SharedPreferences
    private val SELECTION_KEY = "selection_key"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third)

        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE)
        val editor = sharedPreferences.edit()



        val brand = sharedPreferences.getString("brand", "")

        if (brand == "Samsung") {
            items = arrayOf("Galaxy S24 Ultra", "Galaxy Z Fold 6", "Galaxy Z Flip 6", "Galaxy S24", "Galaxy A35")
            prices = arrayOf("$1960", "$2564", "$1462", "$1179", "$399")
        } else if (brand == "GooglePixel") {
            items = arrayOf("Pixel 9 Pro", "Pixel 9 Pro Fold", "Pixel 9", "Pixel 8a", "Pixel 7a")
            prices = arrayOf("$1349", "$2399", "$1099", "$679", "$599")
        } else {
            items = arrayOf("iPhone 16 Pro", "iPhone 16", "iPhone 15", "iPhone 14", "iPhone SE")
            prices = arrayOf("$999", "$799", "$699", "$599", "$429")
        }

        val listItems = Array(items.size) { "" }

        for (i in items.indices) {
            listItems[i] = "${items[i]} ${prices[i]}"
        }

        // declare default value
        editor.putString("model", items[0])
        editor.putString("price", prices[0])
        editor.apply()


        // Reference to the ListView
        val listView = findViewById<ListView>(R.id.listView)

        // Set up ArrayAdapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        listView.adapter = adapter



        // Set up an item click listener to save selection
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selectedItem = items[position]
            val selectedPrice = prices[position]
            Toast.makeText(this, "Selected: $selectedItem", Toast.LENGTH_SHORT).show()

            // Save selection to SharedPreferences
            editor.putString("model", selectedItem)
            editor.putString("price", selectedPrice)
            editor.apply()
        }


        // color
        val spinner: Spinner = findViewById(R.id.spinner)

        val colors = arrayOf("Red", "Blue", "Black", "Silver", "Green")

        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, colors)

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = spinnerAdapter



        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedColor = colors[position]
                editor.putString("color", selectedColor)
                editor.apply()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                editor.putString("color", colors[0])
                editor.apply()
            }
        }

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)

        val defaultRadioButton = findViewById<RadioButton>(R.id.radioButton64GB)
        defaultRadioButton.isChecked = true
        editor.putString("storage", "64GB")
        editor.apply()

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val radioButton = findViewById<RadioButton>(checkedId)

            editor.putString("storage", radioButton.text.toString())
            editor.apply()
        }

        val button = findViewById<Button>(R.id.button3)

        button.setOnClickListener {
            val intent = Intent(this, ForthActivity::class.java)

            startActivity(intent)
        }










        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }



}