package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mConstraintLayout:ConstraintLayout = findViewById(R.id.constraint)
        val textView: TextView = findViewById(R.id.textView);
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this@MainActivity, SettingActivity::class.java)
            startActivity(intent)
        }
        val edit: EditText = findViewById(R.id.edit)
        val buttonText: Button = findViewById(R.id.button3)
        buttonText.setOnClickListener {
            var colorText = edit.text.toString()
            textView.setTextColor(Color.parseColor(colorText))

        }
        val buttonPal: Button = findViewById(R.id.button4)
        buttonPal.setOnClickListener {
            val intent = Intent("android.intent.action.ColorActivity")
            startActivityForResult(intent,2)

        }

        var animat = intent.getIntExtra("anim",0)
        var col = intent.getIntExtra("color",0)

        when (col) {
            1 -> {
                mConstraintLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.Red))
                }

            2 -> {
                mConstraintLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.Blue))
                }

            3 -> {
                mConstraintLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.Green))
               }

            4 -> {
                mConstraintLayout.setBackgroundColor(Color.parseColor("#9C27B0"))
                }
            5 -> {
                mConstraintLayout.setBackgroundColor(Color.parseColor("#FFEB3B"))
            }

            6 -> {
                mConstraintLayout.setBackgroundColor(Color.parseColor("#00BCD4"))
            }

            7 -> {
                mConstraintLayout.setBackgroundColor(Color.parseColor("#FF9800"))
            }

            8 -> {
                mConstraintLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
            }
            9 ->{
                mConstraintLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
            }
            0 ->{
                getColor(R.color.white)
            }
        }

        val animation: Animation;
        when (animat) {
            1 -> {
                animation = AnimationUtils.loadAnimation(this, R.anim.alfa);
                textView.startAnimation(animation)}

            2 -> {
                animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
                textView.startAnimation(animation)}

            3 -> {
                animation = AnimationUtils.loadAnimation(this, R.anim.scale);
                textView.startAnimation(animation)}

            4 -> {
                animation = AnimationUtils.loadAnimation(this, R.anim.translate);
                textView.startAnimation(animation)}
            0 ->{
                textView.clearAnimation()
            }
        }

    }


}