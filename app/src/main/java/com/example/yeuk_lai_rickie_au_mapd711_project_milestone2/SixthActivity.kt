package com.example.yeuk_lai_rickie_au_mapd711_project_milestone2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SixthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sixth)




        val creditCardButton = findViewById<Button>(R.id.creditCardButton)
        val debitCardButton = findViewById<Button>(R.id.debitCardButton)
        val googleAppleButton = findViewById<Button>(R.id.googleAppleButton)

        creditCardButton.setOnClickListener {
            nextScreen("creditCard")
        }

        debitCardButton.setOnClickListener {
            nextScreen("debitCard")
        }

        googleAppleButton.setOnClickListener {
            nextScreen("googleApplePay")
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun nextScreen(method: String) {
        val sharedPreferences = getSharedPreferences("data", MODE_PRIVATE)

        val editor = sharedPreferences.edit()
        editor.putString("paymentMethod", method)
        editor.apply()
        val intent = Intent(this, SeventhActivity::class.java)
        startActivity(intent)
    }
}