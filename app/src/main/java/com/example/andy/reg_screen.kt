package com.example.andy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class reg_screen : AppCompatActivity() {
    public lateinit var name: EditText
    public lateinit var EmalAddress: EditText
    public lateinit var Password: EditText
    public lateinit var Blood_Group: EditText
    public lateinit var mobile_no: EditText
    public lateinit var location: EditText
    public lateinit var register2 : Button
    public lateinit var login2 : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reg_screen)

        name = findViewById(R.id.name)
        EmalAddress = findViewById<EditText>(R.id.EmailAddress)
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