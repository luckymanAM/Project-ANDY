package com.example.andy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase



class RegScreen : AppCompatActivity() {

    lateinit var Naam: EditText
    lateinit var EmailAddress: EditText
    lateinit var Password: EditText
    lateinit var Blood_Group: EditText
    lateinit var mobile_no: EditText
    lateinit var location: EditText
    lateinit var register2 : Button
    lateinit var login2 : Button
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reg_screen)

        auth = FirebaseAuth.getInstance()
        Naam = findViewById(R.id.name)
        EmailAddress = findViewById<EditText>(R.id.EmailAddress)
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
            startActivity(Intent(this, login::class.java))

        }

        register2.setOnClickListener {
            val name = Naam.text.trim().toString()
            val email = EmailAddress.text.trim().toString()
            val password = Password.text.trim().toString()
            val phoneNumber = mobile_no.text.trim().toString()
            val bloodGroup = Blood_Group.text.trim().toString()
            val address = location.text.trim().toString()


            database = FirebaseDatabase.getInstance().getReference("Users")
            val userID = database.push().key
            Toast.makeText(this, "UserId${userID}", Toast.LENGTH_SHORT).show()
            val user = User(userID, bloodGroup, email, address, phoneNumber, name, password)
            if (userID != null) {
                database.child("Users").child(userID).setValue(user).addOnSuccessListener {
                    Blood_Group.text.clear()
                    EmailAddress.text.clear()
                    location.text.clear()
                    mobile_no.text.clear()
                    Naam.text.clear()
                    Password.text.clear()

                    Toast.makeText(this, "Data Saved to Database", Toast.LENGTH_SHORT).show()

                }.addOnFailureListener {

                    Toast.makeText(this, "Failed to save data", Toast.LENGTH_SHORT).show()
                }
            }



            if (name.isEmpty()) {
                Naam.error = "Name Required"
                Naam.requestFocus()
                return@setOnClickListener
            }

            if (email.isEmpty()) {
                EmailAddress.error = "Email Required"
                EmailAddress.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                EmailAddress.error = "Valid Email Required"
                EmailAddress.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty() || password.length < 6) {
                Password.error = "6 char password required"
                Password.requestFocus()
                return@setOnClickListener
            }

            if(phoneNumber.isEmpty() || phoneNumber.length < 10){
                mobile_no.error = "Enter valid Number"
                mobile_no.requestFocus()
                return@setOnClickListener
            }

            if (bloodGroup.isEmpty()) {
                Blood_Group.error = "Enter Blood Group"
                Blood_Group.requestFocus()
                return@setOnClickListener
            }

            if (address.isEmpty()) {
                location.error = "Enter Address"
                Password.requestFocus()
                return@setOnClickListener
            }

            createUser(email, password)
                                                // set for already exist users

        }
        auth.currentUser?.let {
            login()
        }


    }

    fun createUser(email: String, password: String){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){task ->

                if (task.isSuccessful){
                    //Log.e("task message", "Regestered Successfully")
                    login()
                    Toast.makeText(this,"Registered Successfully", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, login::class.java))
                }else{
                    //Log.e("task", "Failed..."+task.exception)
                    task.exception?.message?.let {
                        Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                    }
                }
            }

    }


}