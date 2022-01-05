package com.example.andy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class reg_screen : AppCompatActivity() {
    public lateinit var name: TextView
    public lateinit var EmalAddress: TextView
    public lateinit var Password: TextView
    public lateinit var Blood_Group: TextView
    public lateinit var mobile_no: TextView
    public lateinit var location: TextView
    public lateinit var register2 : Button
    public lateinit var login2 : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reg_screen)

        name = findViewById(R.id.name)
        EmalAddress = findViewById<TextView>(R.id.EmailAddress)
        Password = findViewById(R.id.Password)
        Blood_Group = findViewById(R.id.Blood_Group)
        mobile_no = findViewById(R.id.mobile_no)
        location = findViewById(R.id.location)
        register2 = findViewById(R.id.register2)
        login2 = findViewById(R.id.login2)

    }

    override fun onStart() {
        super.onStart()
        login2.setOnClickListener {
            var intent = Intent(this, login::class.java)
            startActivity(intent)

        }

        //check verification page for register2
    /*
        register2.setOnClickListener {
            var intent = Intent(this, login::class.java)
            startActivity(intent)

        }*/


    }

}