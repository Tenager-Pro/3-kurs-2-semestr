package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class GridActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid)
        val countriesList = findViewById<GridView>(R.id.gridView1)


        val text = intent.extras!!.getString("text").toString()
        val color = intent.extras!!.getString("color").toString()
        val horizontalSpacing = intent.extras!!.getString("horizontalSpacing").toString()

        countriesList.horizontalSpacing = horizontalSpacing.toInt()
        val strs = text.split(" ").toTypedArray()

        // создаем адаптер
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, strs)
        countriesList.adapter = adapter
        when(color) {
            "Red" -> {
                countriesList.setBackgroundColor(getColor(R.color.Red))
            }
            "Green" -> {
                countriesList.setBackgroundColor(getColor(R.color.Green))
            }
            "Blue" -> {
                countriesList.setBackgroundColor(getColor(R.color.Blue))
            }
            else -> {
                countriesList.setBackgroundColor(getColor(R.color.white))
            }
        }




        val itemListener = AdapterView.OnItemClickListener { parent, v,
                                                             position, id ->
            Toast.makeText(
                applicationContext, "Вы выбрали " +
                        parent.getItemAtPosition(position).toString(),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}