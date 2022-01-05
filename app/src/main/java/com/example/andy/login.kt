package com.example.andy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class login : AppCompatActivity() {
    public lateinit var Register_now: Button
    public lateinit var Forgetpss: Button
    public lateinit var Login: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        Register_now = findViewById(R.id.Register_Now)
        Forgetpss = findViewById(R.id.Forgetpss)
        Login = findViewById(R.id.login)
    }

    override fun onStart() {
        super.onStart()
        Register_now.setOnClickListener {
            var intent = Intent(this, reg_screen::class.java)
            startActivity(intent)
        }

        Forgetpss.setOnClickListener {
            var intent = Intent(this, Reset_Password::class.java)
            startActivity(intent)
        }
        Login.setOnClickListener {
            var intent = Intent(this, homepage::class.java)
            startActivity(intent)
        }


    }
}