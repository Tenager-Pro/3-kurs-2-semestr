package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button

class ColorActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color)
        val button: Button = findViewById(R.id.buttonBackMenu)
        button.setOnClickListener {
            val intent = Intent(this@ColorActivity, SettingActivity::class.java)
            startActivity(intent)
        }
    }
}

