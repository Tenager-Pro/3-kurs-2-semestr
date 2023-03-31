package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonEx1: Button = findViewById(R.id.button)
        buttonEx1.setOnClickListener {

        }

        val buttonEx2: Button = findViewById(R.id.button2)
        buttonEx2.setOnClickListener {
            val intent = Intent(this@MainActivity, Ex2::class.java)
            startActivity(intent)
        }

        val buttonEx4: Button = findViewById(R.id.button4)
        buttonEx4.setOnClickListener {
            val intent = Intent(this@MainActivity, Ex4::class.java)
            startActivity(intent)
        }
        val buttonEx6: Button = findViewById(R.id.button6)
        buttonEx6.setOnClickListener {
            val intent = Intent(this@MainActivity, Ex6::class.java)
            startActivity(intent)
        }
        val buttonEx7: Button = findViewById(R.id.button7)
        buttonEx7.setOnClickListener {
            val intent = Intent(this@MainActivity, Ex7::class.java)
            startActivity(intent)
        }
        val db = baseContext.openOrCreateDatabase("app.db", MODE_PRIVATE, null)

        db.execSQL("CREATE TABLE IF NOT EXISTS managers " +
                "(id INTEGER primary key autoincrement," +
                "name VARCHAR(256), " +
                "gender VARCHAR(256)," +
                "age INTEGER, " +
                "education VARCHAR(256)," +
                "post VARCHAR(256)," +
                "wages INTEGER," +
                "experience INTEGER);"
        )
        db.execSQL("INSERT OR IGNORE INTO managers VALUES " +
                "(1,'Tom Smith', 'man',26,'higher','director',30000,5), " +
                "(2,'Fred Smith', 'man',28,'higher','director',35000,5)," +
                "(3,'Ivan Smith', 'man',22,'higher','director',45000,4)," +
                "(4,'Andrey Smith', 'man',27,'higher','director',60000,3)," +
                "(5,'Artem Smith', 'man',28,'higher','director',20000,2)," +
                "(6,'Garry Smith', 'man',19,'higher','director',15000,1)," +
                "(7,'Sirius Smith', 'man',45,'higher','director',18000,9)," +
                "(8,'Pedro Smith', 'man',34,'higher','director',19000,14)," +
                "(9,'Grogu Smith', 'man',26,'higher','director',21000,20)," +
                "(10,'Din Garin', 'man',42,'higher','director',45000,14)," +
                "(11,'Asoka Tano', 'woman',27,'higher','director',22000,1)," +
                "(12,'Dart Mall', 'man',25,'higher','director',34000,2)," +
                "(13,'Dart Veider', 'man',26,'higher','director',30000,6)," +
                "(14,'Dart Sidius', 'man',29,'higher','director',19000,8)," +
                "(15,'Den Smith', 'man',28,'higher','director',20000,7); ")

        val query = db.rawQuery("SELECT * FROM managers;", null)
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = ""
        while (query.moveToNext()) {
            val name = query.getString(1)
            val gender = query.getString(2)
            val age = query.getInt(3)
            val education = query.getString(4)
            val post = query.getString(5)
            val wages = query.getInt(6)
            val experience = query.getInt(7)
            textView.append("Name: $name Gender: $gender Age: $age Education: $education Post: $post Wages: $wages Experience: $experience\n ")
        }
        query.close()
        db.close()
    }
}