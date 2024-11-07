package com.example.yeuk_lai_rickie_au_mapd711_project_milestone2

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EighthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_eighth)


        val sharedPreferences = getSharedPreferences("data", MODE_PRIVATE)

        val textDisplay = findViewById<TextView>(R.id.output2)

        val name = sharedPreferences.getString("name", "error")
        val street = sharedPreferences.getString("street", "error")
        val city = sharedPreferences.getString("city", "error")
        val postalCode = sharedPreferences.getString("postalCode", "error")
        val phone = sharedPreferences.getString("phone", "error")
        val email = sharedPreferences.getString("email", "error")
        val paymentMethod = sharedPreferences.getString("paymentMethod", "error")
        val paymentInfo = sharedPreferences.getString("paymentInfo", "error")

        val brand = sharedPreferences.getString("brand", "error")
        val model = sharedPreferences.getString("model", "error")
        val price = sharedPreferences.getString("price", "error")
        val storage = sharedPreferences.getString("storage", "error")
        val color = sharedPreferences.getString("color", "error")



        // display the text
        textDisplay.text = "Name: ${name}\nStreet: ${street}\n" +
                "City: ${city}\nPostal Code: ${postalCode}\n" +
                "Phone: ${phone}\nEmail: ${email}\n" +
                "Payment Method: ${paymentMethod}\n${paymentInfo}\n" +
                "Brand: ${brand}\nModel: ${model}\nPrice: ${price}\n" +
                "Storage: ${storage}\nColor: ${color}\n"








        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}