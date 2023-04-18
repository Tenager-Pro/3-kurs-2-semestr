package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DatabaseHelper(applicationContext)
    }
    fun ex1(view: View) {
        val intent = Intent(this, ListActivity::class.java).apply {
            putExtra("query_name", "query1")
            putExtra("query", "SELECT * FROM " + DatabaseHelper.TABLE_NAME +
                    " ORDER BY " + DatabaseHelper.COL_WAGES)
        }
        startActivity(intent)
    }

    fun ex2(view: View) {
        val intent = Intent(this, ListActivity::class.java).apply {
            putExtra("query_name", "query2")
            putExtra("query", "SELECT * FROM " + DatabaseHelper.TABLE_NAME +
                    " GROUP BY " + DatabaseHelper.COL_GENDER + ", " + DatabaseHelper.COL_WAGES)
        }
        startActivity(intent)
    }


    fun ex3(view: View) {
        val intent = Intent(this, ListActivity::class.java).apply {
            putExtra("query_name", "query3")
            putExtra("query", "SELECT SUM(" + DatabaseHelper.COL_WAGES
                    + ") FROM " + DatabaseHelper.TABLE_NAME)
        }
        startActivity(intent)
    }


    fun ex4(view: View) {
        val intent = Intent(this, ListActivity::class.java).apply {
            putExtra("query_name", "query4")
            putExtra("query", "SELECT " + DatabaseHelper.COL_GENDER + ", AVG(" + DatabaseHelper.COL_AGE + ") FROM "
                    + DatabaseHelper.TABLE_NAME + " GROUP BY " + DatabaseHelper.COL_GENDER)
        }
        startActivity(intent)
    }


    fun ex5(view: View) {
        val intent = Intent(this, ListActivity::class.java).apply {
            putExtra("query_name", "query5")
            putExtra("query", "SELECT * FROM " + DatabaseHelper.TABLE_NAME + " WHERE " +
                    DatabaseHelper.COL_WAGES + " = (SELECT MAX(" + DatabaseHelper.COL_WAGES
                    + ") FROM " + DatabaseHelper.TABLE_NAME + ")")
        }
        startActivity(intent)
    }


    fun ex6(view: View) {
        val intent = Intent(this, ListActivity::class.java).apply {
            putExtra("query_name", "query6")
            putExtra("query", "SELECT * FROM " + DatabaseHelper.TABLE_NAME + " WHERE " +
                    DatabaseHelper.COL_WAGES + " > 21000")
        }
        startActivity(intent)
    }


    fun ex7(view: View) {
        val intent = Intent(this, ListActivity::class.java).apply {
            putExtra("query_name", "query7")
            putExtra("query", "SELECT * FROM " + DatabaseHelper.TABLE_NAME + " WHERE " +
                    DatabaseHelper.COL_AGE + " < (SELECT AVG(" + DatabaseHelper.COL_AGE
                    + ") FROM " + DatabaseHelper.TABLE_NAME + ")")
        }
        startActivity(intent)
    }


    fun ex8(view: View) {
        val intent = Intent(this, ListActivity::class.java).apply {
            putExtra("query_name", "query8")
            putExtra("query", "SELECT * FROM " + DatabaseHelper.TABLE_NAME + " WHERE " +
                    DatabaseHelper.COL_EXPERIENCE + " > 10 LIMIT 1")
        }
        startActivity(intent)
    }
}
