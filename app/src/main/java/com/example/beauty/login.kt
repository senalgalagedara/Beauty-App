package com.example.beautyapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

    private lateinit var etEmail: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var cbRememberMe: CheckBox
    private lateinit var tvForgotPassword: TextView
    private lateinit var btnSignIn: Button
    private lateinit var btnFacebook: ImageView
    private lateinit var btnGoogle: ImageView
    private lateinit var btnApple: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initViews()
        setupClickListeners()
    }

    private fun initViews() {
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        cbRememberMe = findViewById(R.id.cbRememberMe)
        tvForgotPassword = findViewById(R.id.tvForgotPassword)
        btnSignIn = findViewById(R.id.btnSignIn)
        btnFacebook = findViewById(R.id.btnFacebook)
        btnGoogle = findViewById(R.id.btnGoogle)
        btnApple = findViewById(R.id.btnApple)
    }

    private fun setupClickListeners() {
        btnSignIn.setOnClickListener {
            handleSignIn()
        }

        tvForgotPassword.setOnClickListener {
            Toast.makeText(this, "Forgot Password clicked", Toast.LENGTH_SHORT).show()
            // Implement forgot password logic
        }

        btnFacebook.setOnClickListener {
            handleSocialLogin("Facebook")
        }

        btnGoogle.setOnClickListener {
            handleSocialLogin("Google")
        }

        btnApple.setOnClickListener {
            handleSocialLogin("Apple")
        }
    }

    private fun handleSignIn() {
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString().trim()

        if (validateInput(email, password)) {
            // Login successful, navigate to home
            Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, HomeActivity::class.java))
            finish() // Close login activity
        }
    }

    private fun validateInput(email: String, password: String): Boolean {
        if (email.isEmpty()) {
            etEmail.error = "Email is required"
            etEmail.requestFocus()
            return false
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.error = "Please enter a valid email"
            etEmail.requestFocus()
            return false
        }

        if (password.isEmpty()) {
            etPassword.error = "Password is required"
            etPassword.requestFocus()
            return false
        }

        if (password.length < 6) {
            etPassword.error = "Password must be at least 6 characters"
            etPassword.requestFocus()
            return false
        }

        return true
    }

    private fun handleSocialLogin(platform: String) {
        Toast.makeText(this, "$platform login clicked", Toast.LENGTH_SHORT).show()
        // Implement social login logic here
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}