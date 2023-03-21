package com.release.gfg1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.lr4.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // below code is to add on click
        // listener to our add name button
        findViewById<Button>(R.id.addName).setOnClickListener{

            // below we have created
            // a new DBHelper class,
            // and passed context to it
            val db = DBHelper(this, null)

            // creating variables for values
            // in name and age edit texts
            val name = findViewById<EditText>(R.id.enterName).text.toString()
            val age = findViewById<EditText>(R.id.enterAge).text.toString()

            // calling method to add
            // name to our database
            db.addName(name, age)

            // Toast to message on the screen
            Toast.makeText(this, name + " added to database", Toast.LENGTH_LONG).show()

            // at last, clearing edit texts
            findViewById<EditText>(R.id.enterName).text.clear()
            findViewById<EditText>(R.id.enterAge).text.clear()
        }

        // below code is to add on click
        // listener to our print name button

    }
}
