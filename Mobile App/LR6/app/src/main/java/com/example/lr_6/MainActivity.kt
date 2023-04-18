package com.example.lr_6

import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.cursoradapter.widget.SimpleCursorAdapter

class MainActivity : AppCompatActivity() {
    val LOG_TAG = "myLogs"
    val CONTACT_URI: Uri = Uri.parse("content://com.example.carbasedata.CarProvider/car")
    val CONTACT_STAMP = "stamp"
    val CONTACT_MODEL = "model"
    val CONTACT_YEAR = "year"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cursor: Cursor? = contentResolver.query(CONTACT_URI, arrayOf(CONTACT_STAMP, CONTACT_MODEL, CONTACT_YEAR), null, null, null)
        val buttonNext:Button = findViewById(R.id.button)
        val editTextStamp:EditText = findViewById(R.id.editText)
        val editTextModel:EditText = findViewById(R.id.editText2)
        val editTextYear:EditText = findViewById(R.id.editText3)
        buttonNext.setOnClickListener{
            System.out.println("1")
            System.out.println(cursor.toString())
            if(cursor?.moveToNext()!!) {
                editTextStamp.setText(cursor.getString(1))
                editTextModel.setText(cursor.getString(2))
                editTextYear.setText((cursor.getInt(3)).toString())
            }
        }


    }
}