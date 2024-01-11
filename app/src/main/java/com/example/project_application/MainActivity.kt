package com.example.project_application

import com.example.project_application.R as AppR
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(AppR.layout.activity_main)

        val loginButton: Button = findViewById(AppR.id.logininitial)
        loginButton.setOnClickListener {
            // When the login button is clicked, start the LoginActivity
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
        }

        val signupButton: Button = findViewById(AppR.id.signupinitial)
        signupButton.setOnClickListener {
            // When the signup button is clicked, start the SignupActivity
            val intent = Intent(this@MainActivity, SignActivity::class.java)
            startActivity(intent)
        }
    }
}



