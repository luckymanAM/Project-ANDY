package com.example.andy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Onboarding3 : AppCompatActivity() {
    public lateinit var login: Button
    public lateinit var register:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding3)

        login = findViewById<Button>(R.id.login)
        register = findViewById<Button>(R.id.register)
    }

    override fun onStart() {
        super.onStart()
        login.setOnClickListener {
            val intent = Intent(this, com.example.andy.LoginStart::class.java)
            startActivity(intent)
        }

        register.setOnClickListener {
            val intent = Intent(this, reg_screen::class.java)
            startActivity(intent)
        }


    }
}