package com.example.andy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

import com.google.firebase.auth.FirebaseAuth

class verify_screen1 : AppCompatActivity() {
     lateinit var verify_btn : Button
     lateinit var resend_code : Button
     private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify_screen1)

        verify_btn = findViewById(R.id.verify_btn)
        resend_code = findViewById(R.id.resend_codes)
        auth = FirebaseAuth.getInstance()
    }

    override fun onStart() {
        super.onStart()
        verify_btn.setOnClickListener {
            startActivity(Intent(this, verify_screen2::class.java))

        }
            //// take email from previous activity
        /*resend_code.setOnClickListener {
            auth.sendPasswordResetEmail(email_input_edittext).addOnSuccessListener {
                Toast.makeText(this, "Email link sent Successfully", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, verify_screen2::class.java))
        }*/
    }
}
