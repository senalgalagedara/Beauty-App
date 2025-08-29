package com.example.beautyapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    private lateinit var menuIcon: ImageView
    private lateinit var categoryPedicure: LinearLayout
    private lateinit var categoryFacial: LinearLayout
    private lateinit var categoryWaxing: LinearLayout
    private lateinit var categoryManicure: LinearLayout
    private lateinit var categoryHairServices: LinearLayout
    private lateinit var categoryMakeup: LinearLayout
    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initViews()
        setupClickListeners()
        setupBottomNavigation()
    }

    private fun initViews() {
        menuIcon = findViewById(R.id.menuIcon)
        categoryPedicure = findViewById(R.id.categoryPedicure)
        categoryFacial = findViewById(R.id.categoryFacial)
        categoryWaxing = findViewById(R.id.categoryWaxing)
        categoryManicure = findViewById(R.id.categoryManicure)
        categoryHairServices = findViewById(R.id.categoryHairServices)
        categoryMakeup = findViewById(R.id.categoryMakeup)
        bottomNavigation = findViewById(R.id.bottom_navigation)
    }

    private fun setupClickListeners() {
        menuIcon.setOnClickListener {
            Toast.makeText(this, "Menu clicked", Toast.LENGTH_SHORT).show()
        }

        categoryPedicure.setOnClickListener {
            Toast.makeText(this, "Pedicure services", Toast.LENGTH_SHORT).show()
        }

        categoryFacial.setOnClickListener {
            // Navigate to facial detail page
            startActivity(Intent(this, FacialDetailActivity::class.java))
        }

        categoryWaxing.setOnClickListener {
            Toast.makeText(this, "Waxing services", Toast.LENGTH_SHORT).show()
        }

        categoryManicure.setOnClickListener {
            Toast.makeText(this, "Manicure services", Toast.LENGTH_SHORT).show()
        }

        categoryHairServices.setOnClickListener {
            Toast.makeText(this, "Hair services", Toast.LENGTH_SHORT).show()
        }

        categoryMakeup.setOnClickListener {
            Toast.makeText(this, "Makeup services", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupBottomNavigation() {
        bottomNavigation.selectedItemId = R.id.nav_home

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // Already on home
                    true
                }
                R.id.nav_appointment -> {
                    startActivity(Intent(this, AppointmentActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.nav_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                else -> false
            }
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity() // Close all activities and exit app
    }
}