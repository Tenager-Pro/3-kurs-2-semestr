package com.example.myapplication

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context?) : SQLiteOpenHelper(context, DATABASE_NAME, null, SCHEMA) {

    companion object {

        private const val DATABASE_NAME = "mangers.db"
        private const val SCHEMA = 1
        const val TABLE_NAME = "manager"

        const val COL_ID = "_id"
        const val COL_GENDER = "gender"
        const val COL_AGE = "age"
        const val COL_EDUCATION = "education"
        const val COL_POST = "post"
        const val COL_WAGES = "wages"
        const val COL_EXPERIENCE = "experience"
    }


    override fun onCreate(db: SQLiteDatabase) {

        db.execSQL("CREATE TABLE $TABLE_NAME (" +
                "$COL_ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "$COL_GENDER VARCHAR(256),"+
                "$COL_AGE INTEGER,"+
                "$COL_EDUCATION VARCHAR(256),"+
                "$COL_POST VARCHAR(256),"+
                "$COL_WAGES INTEGER,"+
                "$COL_EXPERIENCE INTEGER);")

        db.execSQL("INSERT INTO $TABLE_NAME ($COL_GENDER, $COL_AGE, $COL_EDUCATION, $COL_POST,$COL_WAGES,$COL_EXPERIENCE) " +
                "VALUES ('man',26,'higher','director',30000,5);")
        db.execSQL("INSERT INTO $TABLE_NAME ($COL_GENDER, $COL_AGE, $COL_EDUCATION, $COL_POST,$COL_WAGES,$COL_EXPERIENCE) " +
                "VALUES ('man',22,'higher','director',45000,4);")
        db.execSQL("INSERT INTO $TABLE_NAME ($COL_GENDER, $COL_AGE, $COL_EDUCATION, $COL_POST,$COL_WAGES,$COL_EXPERIENCE) " +
                "VALUES ('man',27,'higher','director',60000,3);")
        db.execSQL("INSERT INTO $TABLE_NAME ($COL_GENDER, $COL_AGE, $COL_EDUCATION, $COL_POST,$COL_WAGES,$COL_EXPERIENCE) " +
                "VALUES ('man',28,'higher','director',20000,2);")
        db.execSQL("INSERT INTO $TABLE_NAME ($COL_GENDER, $COL_AGE, $COL_EDUCATION, $COL_POST,$COL_WAGES,$COL_EXPERIENCE) " +
                "VALUES ('man',19,'higher','director',15000,1);")
        db.execSQL("INSERT INTO $TABLE_NAME ($COL_GENDER, $COL_AGE, $COL_EDUCATION, $COL_POST,$COL_WAGES,$COL_EXPERIENCE) " +
                "VALUES ('man',45,'higher','director',18000,9);")
        db.execSQL("INSERT INTO $TABLE_NAME ($COL_GENDER, $COL_AGE, $COL_EDUCATION, $COL_POST,$COL_WAGES,$COL_EXPERIENCE) " +
                "VALUES ('man',34,'higher','director',19000,14);")
        db.execSQL("INSERT INTO $TABLE_NAME ($COL_GENDER, $COL_AGE, $COL_EDUCATION, $COL_POST,$COL_WAGES,$COL_EXPERIENCE) " +
                "VALUES ('man',26,'higher','director',21000,20);")
        db.execSQL("INSERT INTO $TABLE_NAME ($COL_GENDER, $COL_AGE, $COL_EDUCATION, $COL_POST,$COL_WAGES,$COL_EXPERIENCE) " +
                "VALUES ('man',42,'higher','director',45000,14);")
        db.execSQL("INSERT INTO $TABLE_NAME ($COL_GENDER, $COL_AGE, $COL_EDUCATION, $COL_POST,$COL_WAGES,$COL_EXPERIENCE) " +
                "VALUES ('woman',27,'higher','director',22000,1);")
        db.execSQL("INSERT INTO $TABLE_NAME ($COL_GENDER, $COL_AGE, $COL_EDUCATION, $COL_POST,$COL_WAGES,$COL_EXPERIENCE) " +
                "VALUES ('man',25,'higher','director',34000,2);")
        db.execSQL("INSERT INTO $TABLE_NAME ($COL_GENDER, $COL_AGE, $COL_EDUCATION, $COL_POST,$COL_WAGES,$COL_EXPERIENCE) " +
                "VALUES ('woman',26,'higher','director',30000,6);")
        db.execSQL("INSERT INTO $TABLE_NAME ($COL_GENDER, $COL_AGE, $COL_EDUCATION, $COL_POST,$COL_WAGES,$COL_EXPERIENCE) " +
                "VALUES ('man',29,'higher','director',19000,8);")
        db.execSQL("INSERT INTO $TABLE_NAME ($COL_GENDER, $COL_AGE, $COL_EDUCATION, $COL_POST,$COL_WAGES,$COL_EXPERIENCE) " +
                "VALUES ('man',28,'higher','director',20000,7);")
        db.execSQL("INSERT INTO $TABLE_NAME ($COL_GENDER, $COL_AGE, $COL_EDUCATION, $COL_POST,$COL_WAGES,$COL_EXPERIENCE) " +
                "VALUES ('woman',24,'higher','director',120000,4);")

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
}
