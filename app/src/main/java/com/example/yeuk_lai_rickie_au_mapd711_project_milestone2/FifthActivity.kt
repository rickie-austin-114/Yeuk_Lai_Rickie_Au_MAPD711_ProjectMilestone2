package com.example.yeuk_lai_rickie_au_mapd711_project_milestone2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout

class FifthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fifth)

        val nameInput = findViewById<EditText>(R.id.nameInput)
        val streetInput = findViewById<EditText>(R.id.streetInput)
        val cityInput = findViewById<EditText>(R.id.cityInput)
        val postalCodeInput = findViewById<EditText>(R.id.postalCodeInput)
        val emailAddressInput = findViewById<EditText>(R.id.emailAddressInput)
        val phoneNumberInput = findViewById<EditText>(R.id.phoneNumberInput)



        val button = findViewById<Button>(R.id.button5)

        button.setOnClickListener {

            if (nameInput.text.isEmpty() || streetInput.text.isEmpty() ||
                cityInput.text.isEmpty() || postalCodeInput.text.isEmpty() ||
                emailAddressInput.text.isEmpty() || phoneNumberInput.text.isEmpty()
                ) {
                Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show()
            } else {
                val phoneText = phoneNumberInput.text.toString()
                val phoneInt = phoneText.toIntOrNull()

                if (phoneInt != null) {
                    val intent = Intent(this, SixthActivity::class.java)

                    val sharedPreferences = getSharedPreferences("data", MODE_PRIVATE)
                    val editor = sharedPreferences.edit()

                    editor.putString("name", nameInput.text.toString())
                    editor.putString("street", streetInput.text.toString())
                    editor.putString("city", cityInput.text.toString())
                    editor.putString("postalCode", postalCodeInput.text.toString())
                    editor.putString("email", emailAddressInput.text.toString())
                    editor.putString("phone", phoneNumberInput.text.toString())

                    editor.apply()
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show()
                }
            }

        }






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}