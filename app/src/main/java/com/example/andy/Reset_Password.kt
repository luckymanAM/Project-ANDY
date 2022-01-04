package com.example.andy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Reset_Password : AppCompatActivity() {
    public lateinit var send_btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

         send_btn = findViewById(R.id.name)
    }

    override fun onStart() {
        super.onStart()
        send_btn.setOnClickListener {
            var intent = Intent(this, verify_screen1::class.java)
            startActivity(intent)

        }
    }
}