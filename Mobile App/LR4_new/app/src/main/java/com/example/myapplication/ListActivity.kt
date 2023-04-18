package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.database.DatabaseUtils
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.DatabaseHelper
import com.example.myapplication.R
import java.io.IOException
import java.io.OutputStreamWriter


class ListActivity : AppCompatActivity() {

    lateinit var header1: TextView
    lateinit var header2: TextView
    lateinit var list: ListView
    lateinit var databaseHelper: DatabaseHelper
    lateinit var db: SQLiteDatabase
    lateinit var cursor: Cursor
    lateinit var cursorAdapter: SimpleCursorAdapter
    private lateinit var query_name: String
    private lateinit var query: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        header1 =  findViewById<View>(R.id.header1) as TextView
        header2 =  findViewById<View>(R.id.header2) as TextView
        list = findViewById<View>(R.id.list) as ListView
        databaseHelper = DatabaseHelper(applicationContext)

        query_name = intent.extras!!.getString("query_name").toString()
        query = intent.extras!!.getString("query").toString()

        header1.text = query
    }


    @SuppressLint("Range")
    override fun onResume() {
        super.onResume()

        db = databaseHelper.readableDatabase
        cursor =  db.rawQuery(query, null)
        when (query_name) {
            "query1" -> {
                writeToFile(query_name, DatabaseUtils.dumpCursorToString(cursor))
            }
            "query3" -> {
                writeToFile(query_name, DatabaseUtils.dumpCursorToString(cursor))
            }
            "query4" -> {
                writeToFile(query_name, DatabaseUtils.dumpCursorToString(cursor))
            }
        }

        writeToLogcat(query_name, DatabaseUtils.dumpCursorToString(cursor))

        when (query_name) {
            "query3" -> {
                cursor.moveToFirst()
                header2.text = "SUM: " + cursor.getString(0)
            }

            "query4" -> {
                var data: String = ""
                cursor.moveToFirst()
                while (cursor.moveToNext()) {
                    data += "Gender: " + cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_GENDER)) + "\n"
                    data += "AVG(age): " + cursor.getString(cursor.getColumnIndex("AVG(age)")) + "\n\n"
                }
                header2.text = data
            }
            else -> {
                val headers = arrayOf<String>(
                    DatabaseHelper.COL_GENDER,
                    DatabaseHelper.COL_AGE,
                    DatabaseHelper.COL_EDUCATION,
                    DatabaseHelper.COL_POST,
                    DatabaseHelper.COL_WAGES,
                    DatabaseHelper.COL_EXPERIENCE,
                    )

                cursorAdapter = SimpleCursorAdapter(
                    this,
                    R.layout.activity_list_multi,
                    cursor,
                    headers,
                    intArrayOf(R.id.line1, R.id.line2, R.id.line3, R.id.line4, R.id.line5, R.id.line6),
                    1)

                header2.text = "Найдено элементов: " + cursor.count
                list.adapter = cursorAdapter
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        db.close()
        cursor.close()
    }


    private fun writeToFile(fileName: String, data: String) {
        try {
            val outputStreamWriter = OutputStreamWriter(this.openFileOutput("$fileName.txt", Context.MODE_PRIVATE))
            outputStreamWriter.write(data)
            outputStreamWriter.close()
            Toast.makeText(this, "Данные были сохранены в файл", Toast.LENGTH_LONG).show()
        } catch (e: IOException) {
            Log.e("Exception", "File write failed: $e")
        }
    }


    private fun writeToLogcat(tag: String, data: String) {
        Log.i(tag, data)
        Toast.makeText(this, "Данные были сохранены в LogCat", Toast.LENGTH_LONG).show()
    }
}
