package com.example.bird_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.example.bird_app.databinding.ActivityLoginScreenBinding
import com.example.bird_app.databinding.ActivityRegisterScreenBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterScreen : AppCompatActivity() {


    private lateinit var binding: ActivityRegisterScreenBinding
    private lateinit var firebaseAuth: FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()

        //button reg
        binding.regbtn.setOnClickListener{
            val email= binding.signEmail.text.toString()
            val password= binding.regpassword.text.toString()
            val confirmpawword = binding.confpwrd.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()&& confirmpawword.isNotEmpty()){
               if(password == confirmpawword) {
                   firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{

                       if (it.isSuccessful) {

                           //register btton intent if successfull
                           val signintent1 = Intent(this@RegisterScreen, MainApp1::class.java)
                           //call the intent
                           startActivity(signintent1)
                       } else {
                           Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                       }

                   }


               } else {
                   Toast.makeText(this, "Password does not match, Try Again ", Toast.LENGTH_SHORT).show()
               }
            } else { Toast.makeText(this, "Fields cannot be empty ", Toast.LENGTH_SHORT).show()
            }
        }


        //back btn intent to the main activity
        binding.backbtnTologin.setOnClickListener {
            val Logintent1 = Intent(this@RegisterScreen, LoginScreen::class.java)
            //call the intent
            startActivity(Logintent1)













        }

    }
}