package com.example.yeuk_lai_rickie_au_mapd711_project_milestone2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ForthActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_forth)

        val sharedPreferences = getSharedPreferences("data", MODE_PRIVATE)

        val brand = sharedPreferences.getString("brand", "error")
        val model = sharedPreferences.getString("model", "error")
        val price = sharedPreferences.getString("price", "error")
        val storage = sharedPreferences.getString("storage", "error")
        val color = sharedPreferences.getString("color", "error")

        val textDisplay = findViewById<TextView>(R.id.output1)


        // display the text
        textDisplay.text = "Brand: ${brand}\nModel: ${model}\nPrice: ${price}\n" +
                "Storage: ${storage}\nColor: ${color}\n"

        val button = findViewById<Button>(R.id.button4)

        button.setOnClickListener {
            val intent = Intent(this, FifthActivity::class.java)

            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}