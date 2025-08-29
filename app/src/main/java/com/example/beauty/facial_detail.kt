package com.example.beautyapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class FacialDetailActivity : AppCompatActivity() {

    private lateinit var btnBack: ImageView
    private lateinit var btnAddPearl: CardView
    private lateinit var btnAddGold: CardView
    private lateinit var btnAddDiamond: CardView
    private lateinit var btnAddHerbal: CardView
    private lateinit var btnProceed: Button

    private var selectedServices = mutableListOf<String>()
    private var totalPrice = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facial_detail)

        initViews()
        setupClickListeners()
    }

    private fun initViews() {
        btnBack = findViewById(R.id.btnBack)
        btnProceed = findViewById(R.id.btnProceed)
    }

    private fun setupClickListeners() {
        btnBack.setOnClickListener {
            finish()
        }
    }

    private fun proceedToAppointment() {
        val intent = Intent(this, AppointmentActivity::class.java).apply {
            putStringArrayListExtra("selected_services", ArrayList(selectedServices))
            putExtra("total_price", totalPrice)
        }
        startActivity(intent)
    }
}