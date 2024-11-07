package com.example.yeuk_lai_rickie_au_mapd711_project_milestone2

import android.content.Intent
import android.os.Bundle
import android.renderscript.ScriptGroup.Input
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SeventhActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_seventh)

        val sharedPreferences = getSharedPreferences("data", MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        val paymentMethod = sharedPreferences.getString("paymentMethod", "")

        val inputText1 = findViewById<TextView>(R.id.inputText1)
        val inputText2 = findViewById<TextView>(R.id.inputText2)
        val inputText3 = findViewById<TextView>(R.id.inputText3)


        val inputField1 = findViewById<EditText>(R.id.inputField1)
        val inputField2 = findViewById<EditText>(R.id.inputField2)
        val inputField3 = findViewById<EditText>(R.id.inputField3)


        if (paymentMethod == "creditCard" || paymentMethod == "debitCard") {
            inputText1.text = "Card Number"
            inputText2.text = "Expiratory Date"
            inputText3.text = "Security Code"
        } else {
            inputText1.text = "Email Address"
            inputText2.text = "Password"
            inputField2.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            inputField3.visibility = View.GONE
            inputText3.visibility = View.GONE
        }

        val button = findViewById<Button>(R.id.button7)

        button.setOnClickListener {
            val intent = Intent(this, EighthActivity::class.java)
            if (paymentMethod == "googleApplePay") {
                if (inputText1.text.isNotEmpty() && inputText2.text.isNotEmpty()) {
                    editor.putString("paymentInfo", "Account Email Address: ${inputField1.text.toString()}\nPassword: ${inputField2.text.toString()}")
                    editor.apply()
                    startActivity(intent)
                }
            } else {
                if (inputText1.text.isNotEmpty() && inputText2.text.isNotEmpty()
                    && inputText3.text.isNotEmpty()) {
                    val cardNumber = inputField1.text.toString().toIntOrNull()
                    val securityCode = inputField3.text.toString().toIntOrNull()
                    if (cardNumber != null && securityCode != null) {
                        editor.putString("paymentInfo", "Card Number: ${inputField1.text.toString()}\nExpiratory Date: ${inputField2.text.toString()}\nSecurity Code: ${inputField3.text.toString()}")
                        editor.apply()
                        startActivity(intent)
                    }
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