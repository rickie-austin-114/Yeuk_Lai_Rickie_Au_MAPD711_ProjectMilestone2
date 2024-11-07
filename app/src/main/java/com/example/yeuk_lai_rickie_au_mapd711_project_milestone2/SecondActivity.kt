package com.example.yeuk_lai_rickie_au_mapd711_project_milestone2

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView

class SecondActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE)

        val editor = sharedPreferences.edit()

        // set default value
        editor.putString("brand", "iPhone")
        editor.apply()

        val button = findViewById<Button>(R.id.button2)

        button.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)

            startActivity(intent)
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Inflate the menu; this adds items to the action bar if it is present.
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    // Handle menu item clicks here
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val image: ImageView = findViewById<ImageView>(R.id.phoneImage)

        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE)

        val editor = sharedPreferences.edit()



        return when (item.itemId) {
            R.id.iphone_option -> {
                editor.putString("brand", "iPhone")
                editor.apply()
                image.setImageResource(R.drawable.iphone)
                true
            }
            R.id.google_pixel_option -> {
                editor.putString("brand", "GooglePixel")
                editor.apply()
                image.setImageResource(R.drawable.google_pixel)
                true
            }
            R.id.samsung_option -> {
                editor.putString("brand", "Samsung")
                editor.apply()
                image.setImageResource(R.drawable.samsung)

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}