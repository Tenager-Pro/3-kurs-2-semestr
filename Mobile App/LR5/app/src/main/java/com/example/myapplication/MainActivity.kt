package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun openActivity(view: View){
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val editText = findViewById<EditText>(R.id.editText)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val selected = spinner.getSelectedItem().toString();

        val intent = Intent(this, GridActivity::class.java).apply {
            putExtra("text", editText.text.toString())
            putExtra("horizontalSpacing", selected)

            val checkedRadioButtonId = radioGroup.checkedRadioButtonId
            when(checkedRadioButtonId) {
                -1 -> {
                    val selectedRadioButton = "white"
                    putExtra("color", selectedRadioButton)
                }
                else -> {
                    // Найдём переключатель по его id
                    val selectedRadioButton = findViewById<RadioButton>(checkedRadioButtonId)
                    putExtra("color", selectedRadioButton.text)
                }
            }
        }
        startActivity(intent)
    }
}