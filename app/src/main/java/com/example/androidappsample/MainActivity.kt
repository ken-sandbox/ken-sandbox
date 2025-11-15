package com.example.androidappsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextName: EditText = findViewById(R.id.editTextName)
        val buttonGreet: Button = findViewById(R.id.buttonGreet)
        val textOutput: TextView = findViewById(R.id.textOutput)

        buttonGreet.setOnClickListener {
            val name = editTextName.text.toString()
            val greeting = if (name.isBlank()) {
                getString(R.string.default_greeting)
            } else {
                getString(R.string.greeting_format, name)
            }
            textOutput.text = greeting
        }
    }
}
