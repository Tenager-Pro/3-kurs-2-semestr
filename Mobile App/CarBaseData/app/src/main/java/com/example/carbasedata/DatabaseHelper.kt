package com.example.carbasedata

import android.content.ContentProvider
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DatabaseHelper(context: Context?) : SQLiteOpenHelper(context, DATABASE_NAME, null, SCHEMA) {

    companion object {

        private const val DATABASE_NAME = "cars.db"
        private const val SCHEMA = 1
        const val TABLE_NAME = "car"

        const val COL_ID = "_id"
        const val COL_STAMP = "stamp"
        const val COL_MODEL = "model"
        const val COL_YEAR = "year"

    }


    override fun onCreate(db: SQLiteDatabase) {

        db.execSQL("CREATE TABLE $TABLE_NAME (" +
                "$COL_ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "$COL_STAMP TEXT,"+
                "$COL_MODEL TEXT,"+
                "$COL_YEAR INTEGER);")

        db.execSQL("INSERT INTO $TABLE_NAME ($COL_STAMP, $COL_MODEL, $COL_YEAR) " +
                "VALUES ('ford','focus',2010);")
        db.execSQL("INSERT INTO $TABLE_NAME ($COL_STAMP, $COL_MODEL, $COL_YEAR) " +
                "VALUES ('ford','focus',2011);")
        db.execSQL("INSERT INTO $TABLE_NAME ($COL_STAMP, $COL_MODEL, $COL_YEAR) " +
                "VALUES ('lada','vesta',2010);")
        db.execSQL("INSERT INTO $TABLE_NAME ($COL_STAMP, $COL_MODEL, $COL_YEAR) " +
                "VALUES ('lada','granta',2010);")


    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
}
