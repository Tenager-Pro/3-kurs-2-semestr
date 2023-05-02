package com.example.lb7

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.util.Log
import android.widget.EditText
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class MyWidget : AppWidgetProvider() {
    internal val LOG_TAG = "myLogs"
    override fun onEnabled(context: Context) {
        super.onEnabled(context)
        Log.d(LOG_TAG, "onEnabled")
        val dateFormat = SimpleDateFormat("d MMM yyyy, EEE")
        val date = dateFormat.format(Date())
        val editTextStamp: EditText = findViewById(R.id.editText)
    }
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        super.onUpdate(
            context, appWidgetManager,
            appWidgetIds
        )
        Log.d(LOG_TAG, "onUpdate " +
                Arrays.toString(appWidgetIds))
    }
    override fun onDeleted(
        context: Context,
        appWidgetIds: IntArray
    ) {
        super.onDeleted(context, appWidgetIds)
        Log.d(LOG_TAG, "onDeleted " +
                Arrays.toString(appWidgetIds))
    }
    override fun onDisabled(context: Context) {
        super.onDisabled(context)
        Log.d(LOG_TAG, "onDisabled")
    }
}