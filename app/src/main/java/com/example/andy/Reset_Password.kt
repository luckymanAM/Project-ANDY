package com.example.andy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class Reset_Password : AppCompatActivity() {
    public lateinit var send_btn: Button
    public lateinit var email_input: TextInputEditText
    public lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

         send_btn = findViewById(R.id.send_btn)
        email_input = findViewById(R.id.email_input_edittext)
        text = findViewById(R.id.info_pass_reset)
    }

    override fun onStart() {
        super.onStart()
        send_btn.setOnClickListener {
            var intent = Intent(this, verify_screen1::class.java)
            startActivity(intent)

        }
    }
}