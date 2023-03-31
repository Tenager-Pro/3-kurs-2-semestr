package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASE_NAME = "lr4_new"
val TABLE_NAME = "manager"
val COL_GENDER = "gender"
val COL_AGE = "age"
val COL_ID = "id"
val COL_EDUCATION = "education"
val COL_POST = "post"
val COL_WAGES = "wages"
val COL_EXPERIENCE = "experience"

class DataBaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_NAME +" ("+
                COL_ID+" Integer primary key autoincrement,"+
                COL_GENDER+" VARCHAR(256),"+
                COL_AGE+" Integer,"+
                COL_EDUCATION+" VARCHAR(256),"+
                COL_POST+" VARCHAR(256),"+
                COL_WAGES+"Integer,"+
                COL_EXPERIENCE+" Integer"+");";

        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(manager: Manager){
        val db = this.writableDatabase
        var cv =ContentValues()
        cv.put(COL_GENDER,manager.gender)
        cv.put(COL_AGE,manager.age)
        cv.put(COL_EDUCATION,manager.education)
        cv.put(COL_POST,manager.post)
        cv.put(COL_WAGES,manager.wages)
        cv.put(COL_EXPERIENCE,manager.experience)
        var result = db.insert(TABLE_NAME,null,cv)
        if (result == -1.toLong())
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show()

    }
}