//package com.example.lr_6
//
//import android.R
//import android.app.Activity
//import android.content.ContentUris
//import android.content.ContentValues
//import android.database.Cursor
//import android.os.Bundle
//import android.view.View
//
//
//
//    val LOG_TAG = "myLogs"
//    val CONTACT_URI: Uri = Uri.parse("content://ru.startandroid.providers.AdressBook/contacts")
//    val CONTACT_NAME = "name"
//    val CONTACT_EMAIL = "email"
//    public override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.main)
//        val cursor: Cursor? = contentResolver.query(CONTACT_URI, null, null, null, null)
//        startManagingCursor(cursor)
//        val from = arrayOf("name", "email")
//        val to = intArrayOf(R.id.text1, R.id.text2)
//        val adapter = SimpleCursorAdapter(
//            this,
//            R.layout.simple_list_item_2, cursor, from, to
//        )
//        val lvContact: ListView = findViewById<View>(R.id.lvContact) as ListView
//        lvContact.setAdapter(adapter)
//    }
//
//    fun onClickInsert(v: View?) {
//        val cv = ContentValues()
//        cv.put(CONTACT_NAME, "name 4")
//        cv.put(CONTACT_EMAIL, "email 4")
//        val newUri: Uri? = contentResolver.insert(CONTACT_URI, cv)
//        Log.d(LOG_TAG, "insert, result Uri : " + newUri.toString())
//    }
//
//    fun onClickUpdate(v: View?) {
//        val cv = ContentValues()
//        cv.put(CONTACT_NAME, "name 5")
//        cv.put(CONTACT_EMAIL, "email 5")
//        val uri: Uri = ContentUris.withAppendedId(CONTACT_URI, 2)
//        val cnt = contentResolver.update(uri, cv, null, null)
//        Log.d(LOG_TAG, "update, count = $cnt")
//    }
//
//    fun onClickDelete(v: View?) {
//        val uri: Uri = ContentUris.withAppendedId(CONTACT_URI, 3)
//        val cnt = contentResolver.delete(uri, null, null)
//        Log.d(LOG_TAG, "delete, count = $cnt")
//    }
//
//    fun onClickError(v: View?) {
//        val uri: Uri = Uri.parse("content://ru.startandroid.providers.AdressBook/phones")
//        try {
//            val cursor: Cursor? = contentResolver.query(uri, null, null, null, null)
//        } catch (ex: Exception) {
//            Log.d(LOG_TAG, "Error: " + ex.javaClass + ", " + ex.message)
//        }
//    }
