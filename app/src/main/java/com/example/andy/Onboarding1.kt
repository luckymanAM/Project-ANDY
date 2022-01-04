package com.example.andy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class Onboarding1 : AppCompatActivity() {
    public lateinit var next: Button
    public lateinit var skip:Button

    //var next:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding1)

      //  next = findViewById(R.id.next)
       // skip = findViewById(R.id.skip)

        next = findViewById<Button>(R.id.next)
        skip = findViewById<Button>(R.id.skip)


    }

    override fun onStart() {
        super.onStart()
        next.setOnClickListener {
            val intent = Intent(this, Onboarding2::class.java)
            startActivity(intent)

            
        }



        skip.setOnClickListener {
            val intent = Intent(this, Onboarding3::class.java)
            startActivity(intent)
        }


    }


}