package com.example.carbasedata

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.net.Uri

class CarProvider: ContentProvider() {

    companion object{
        const val TABLE_NAME = "car"
        val PROVIDER_NAME = "com.example.carbasedata.CarProvider"
        val URL = "content://$PROVIDER_NAME/$TABLE_NAME"
        val CONTENT_URI = Uri.parse(URL)

        val _ID = "_id"
        val STAMP = "stamp"
        val MODEL = "model"
        val YEAR = "year"
    }
    lateinit var db: SQLiteDatabase

    override fun onCreate(): Boolean {
        var helper = DatabaseHelper(context)
        db = helper.writableDatabase
        return if(db==null) false else true
    }

    override fun insert(uri: Uri, cv: ContentValues?): Uri? {
        db.insert("$TABLE_NAME",null,cv)
        context?.contentResolver?.notifyChange(uri, null)
        return uri
    }

    override fun update(uri: Uri, cv: ContentValues?, condition: String?, condition_val: Array<out String>?): Int {
        var count = db.update("$TABLE_NAME",cv,condition,condition_val)
        context?.contentResolver?.notifyChange(uri, null)
        return  count
    }

    override fun delete(uri: Uri, condition: String?, condition_val: Array<out String>?): Int {
        var count = db.delete("$TABLE_NAME",condition,condition_val)
        context?.contentResolver?.notifyChange(uri, null)
        return count
    }

    override fun query(
        uri: Uri,
        cols: Array<out String>?,
        condition: String?,
        condition_val: Array<out String>?,
        order: String?
    ): Cursor? {
        return db.query("$TABLE_NAME", cols,condition,condition_val,null,null,order)
    }

    override fun getType(p0: Uri): String? {
        return "vnd.android.cursor.dir/vnd.example.car"
    }
}