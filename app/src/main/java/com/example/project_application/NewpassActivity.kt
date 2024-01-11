package com.example.project_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project_application.R as AppR
import android.content.Intent
import android.widget.Button


class NewpassActivity : AppCompatActivity() {
    private lateinit var btnGoToProducts: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(AppR.layout.activity_newpass)

        val returnloginButton: Button = findViewById(AppR.id.returnlogin)
        returnloginButton.setOnClickListener {
            // When the login button is clicked, start the LoginActivity
            val intent = Intent(this@NewpassActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}