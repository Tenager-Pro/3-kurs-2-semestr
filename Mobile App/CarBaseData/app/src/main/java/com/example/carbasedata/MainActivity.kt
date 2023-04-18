package com.example.carbasedata

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var helper = DatabaseHelper(applicationContext)
        var db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * From car", null)
        if (rs.moveToFirst())
            Toast.makeText(applicationContext, rs.getString(1)+"\n" + rs.getString(2), Toast.LENGTH_LONG).show()

    }
}