package com.example.lb7_2

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.widget.RemoteViews
import java.text.SimpleDateFormat
import java.util.*

/**
 * Implementation of App Widget functionality.
 * App Widget Configuration implemented in [MyWidgetConfigureActivity]
 */
class MyWidget : AppWidgetProvider() {


    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onDeleted(context: Context, appWidgetIds: IntArray) {
        // When the user deletes the widget, delete the preference associated with it.
        for (appWidgetId in appWidgetIds) {
            deleteTitlePref(context, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        super.onEnabled(context)

        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        super.onDisabled(context)
        // Enter relevant functionality for when the last widget is disabled
    }

}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    val widgetText = loadTitlePref(context, appWidgetId)
    val color = loadTitlePref(context, appWidgetId)
    val color_text = loadTitleColor(context, appWidgetId)

    // Construct the RemoteViews object
    val views = RemoteViews(context.packageName, R.layout.my_widget)
    val dateFormat = SimpleDateFormat("d MMM yyyy, EEE")
    val date = dateFormat.format(Date())

    views.setTextColor(R.id.appwidget_text, Color.parseColor("#FFFFFFFF"))
    views.setTextViewText(R.id.appwidget_text, date)
    System.out.println("sdfsd")

    System.out.println(R.id.appwidget_text.toString())

    val configIntent = Intent(context, MyWidgetConfigureActivity::class.java)
    configIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
    val configPendingIntent = PendingIntent.getActivity(context, appWidgetId, configIntent, 0)
    views.setOnClickPendingIntent(R.id.layout_widget, configPendingIntent)
    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, views)
}