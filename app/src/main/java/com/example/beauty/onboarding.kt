package com.example.beautyapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class OnboardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        val btnGetStarted: CardView = findViewById(R.id.btnGetStarted)

        btnGetStarted.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}