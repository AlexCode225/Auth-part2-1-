package com.example.bird_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.bird_app.databinding.ActivityLoginScreenBinding
import com.example.bird_app.databinding.ActivityRegisterScreenBinding
import com.google.firebase.auth.FirebaseAuth

class LoginScreen : AppCompatActivity() {

    private lateinit var binding: ActivityLoginScreenBinding
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()

        //login button
        binding.loginbtn.setOnClickListener {
            val email = binding.usernamelog.text.toString()
            val password = binding.passwordlog.text.toString()


            if (email.isNotEmpty() && password.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val loginintent1 = Intent(this@LoginScreen, MainApp1::class.java)
                        //call the intent
                        startActivity(loginintent1)
                    } else {

                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                    }
                }

            } else {
                Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
            }

        }


        //intent to register page
        //back btn intent to the main activity
        binding.reggbtn.setOnClickListener {
            val regbtnitent1 = Intent(this, RegisterScreen::class.java)
            //call the intent
            startActivity(regbtnitent1)


        }


    }
}
