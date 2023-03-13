package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class SettingActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        val button: Button = findViewById(R.id.button2)
        val buttonPal: Button = findViewById(R.id.button3)
        button.setOnClickListener {
            val intent = Intent(this@SettingActivity, MainActivity::class.java)
            startActivity(intent)
        }
        buttonPal.setOnClickListener {
            val intent = Intent(this@SettingActivity, ColorActivity::class.java)
            startActivity(intent)
        }

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)

        radioGroup.setOnCheckedChangeListener{_,checkedId ->findViewById<RadioButton>(checkedId)?.apply{

            }
        }
    }

}