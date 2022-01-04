package com.example.andy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginStart : AppCompatActivity() {
    public lateinit var Register_now: Button
    public lateinit var forgetpss: Button
    public lateinit var login : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_start)

        Register_now = findViewById(R.id.Register_Now)
        forgetpss = findViewById(R.id.forgetpss)
        login = findViewById(R.id.login)
    }

    override fun onStart() {
        super.onStart()
        Register_now.setOnClickListener {
            var intent = Intent(this, reg_screen::class.java)
            startActivity(intent)
        }

        forgetpss.setOnClickListener {
            var intent = Intent(this, Reset_Password::class.java)
            startActivity(intent)
        }

        login.setOnClickListener {
            var intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

    }
}