package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val context = this
        val button = findViewById<Button>(R.id.button)
        val edit_gender = findViewById<EditText>(R.id.edit)
        val edit_age = findViewById<EditText>(R.id.edit2)
        val edit_education = findViewById<EditText>(R.id.edit3)
        val edit_post = findViewById<EditText>(R.id.edit4)
        val edit_wages = findViewById<EditText>(R.id.edit5)
        val edit_experience = findViewById<EditText>(R.id.edit6)

        button.setOnClickListener({
            if(edit_gender.text.toString().length>0 &&
                edit_age.text.toString().length>0 &&
                edit_education.text.toString().length>0 &&
                edit_post.text.toString().length>0 &&
                edit_wages.text.toString().length>0 &&
                edit_wages.text.toString().length>0 &&
                edit_experience.text.toString().length>0){
                var manager = Manager(
                    edit_gender.text.toString(),
                    edit_age.text.toString().toInt(),
                    edit_education.text.toString(),
                    edit_post.text.toString(),
                    edit_wages.text.toString().toInt(),
                    edit_experience.text.toString().toInt())
                var db = DataBaseHandler(context)
                db.insertData(manager)
            }
            else{
                Toast.makeText(context,"Please Fill All Datas",Toast.LENGTH_SHORT).show()
            }
        })
    }
}