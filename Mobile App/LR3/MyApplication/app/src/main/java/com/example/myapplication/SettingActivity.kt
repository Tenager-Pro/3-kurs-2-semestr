package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class SettingActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        val button: Button = findViewById(R.id.button2)


        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        button.setOnClickListener {
            var flag: Int?
            val checkedRadioButtonId = radioGroup.checkedRadioButtonId
            val selectedRadioButton = findViewById<RadioButton>(checkedRadioButtonId)

            when (selectedRadioButton.id) {
                R.id.radioButton -> {
                    flag = 1
                }

                R.id.radioButton2 -> {
                    flag = 2
                }

                R.id.radioButton3 -> {
                    flag = 3
                }

                R.id.radioButton4 -> {
                    flag = 4
                }
                else ->{
                    flag = 0
                }


            }

            val intent = Intent(this@SettingActivity, MainActivity::class.java)
            intent.putExtra("anim", flag)
            startActivity(intent)
        }





    }

}