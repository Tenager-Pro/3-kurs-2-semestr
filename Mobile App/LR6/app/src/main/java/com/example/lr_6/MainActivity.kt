package com.example.lr_6

import android.content.ContentResolver
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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
        val cursor: Cursor? = contentResolver.query(CONTACT_URI, arrayOf(CONTACT_STAMP, CONTACT_MODEL, CONTACT_YEAR),  null, null, null)
        val buttonNext:Button = findViewById(R.id.button)
        val buttonStart:Button = findViewById(R.id.button2)
        val buttonAdd:Button = findViewById(R.id.button3)
        val buttonDelete:Button = findViewById(R.id.button4)
        val buttonUpdate:Button = findViewById(R.id.button5)
        val buttonClear:Button = findViewById(R.id.button6)
        val editTextStamp:EditText = findViewById(R.id.editText)
        val editTextModel:EditText = findViewById(R.id.editText2)
        val editTextYear:EditText = findViewById(R.id.editText3)

        buttonNext.setOnClickListener{
            if(cursor!= null && cursor.getCount() > 0 && cursor?.moveToNext()!!) {
                editTextStamp.setText(cursor.getString(0))
                editTextModel.setText(cursor.getString(1))
                editTextYear.setText(cursor.getString(2))
            }
            else{

                Toast.makeText(applicationContext, "База данных пуста или не найдена", Toast.LENGTH_LONG).show()
            }
        }

        buttonStart.setOnClickListener{
            if(cursor!= null && cursor.getCount() > 0 && cursor?.moveToFirst()!!) {
                editTextStamp.setText(cursor.getString(0))
                editTextModel.setText(cursor.getString(1))
                editTextYear.setText(cursor.getString(2))
            }
            else{

                Toast.makeText(applicationContext, "База данных пуста или не найдена", Toast.LENGTH_LONG).show()
            }
        }

        buttonAdd.setOnClickListener{
            var cv = ContentValues()
            cv.put(CONTACT_STAMP, editTextStamp.text.toString())
            cv.put(CONTACT_MODEL, editTextModel.text.toString())
            cv.put(CONTACT_YEAR, editTextYear.text.toString())
            contentResolver.insert(CONTACT_URI,cv)
            cursor?.requery()

        }

        buttonUpdate.setOnClickListener{
            var cv = ContentValues()
            cv.put(CONTACT_MODEL, editTextModel.text.toString())
            cv.put(CONTACT_YEAR, editTextYear.text.toString())
            contentResolver.update(CONTACT_URI,cv,"stamp = ?", arrayOf(editTextStamp.text.toString()))
            cursor?.requery()

        }

        buttonDelete.setOnClickListener{
            contentResolver.delete(CONTACT_URI,"stamp = ?", arrayOf(editTextStamp.text.toString()))
            cursor?.requery()

        }
        buttonClear.setOnClickListener{
            editTextStamp.setText("")
            editTextModel.setText("")
            editTextYear.setText("")

        }


    }
}
