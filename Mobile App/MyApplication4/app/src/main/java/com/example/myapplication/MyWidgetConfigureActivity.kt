package com.example.myapplication

import android.app.Activity
import android.appwidget.AppWidgetManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import com.example.myapplication.databinding.MyWidgetConfigureBinding

/**
 * The configuration screen for the [MyWidget] AppWidget.
 */
class MyWidgetConfigureActivity : Activity() {

    private var appWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID
    var text_color: String = "FFFFFF"
    var color: String = "000000"
    private lateinit var appWidgetText: EditText
    private var onClickListener = View.OnClickListener {
        val context = this@MyWidgetConfigureActivity

        // When the button is clicked, store the string locally
        val widgetText = appWidgetText.text.toString()
        saveTitlePref(context, appWidgetId, widgetText)

        // It is the responsibility of the configuration activity to update the app widget

        // Make sure we pass back the original appWidgetId
        val resultValue = Intent()
        resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
        resultValue.putExtra("color", color)
        resultValue.putExtra("color_text", text_color)
        setResult(RESULT_OK, resultValue)
        finish()
    }
    private lateinit var binding: MyWidgetConfigureBinding

    public override fun onCreate(icicle: Bundle?) {
        super.onCreate(icicle)

        // Set the result to CANCELED.  This will cause the widget host to cancel
        // out of the widget placement if the user presses the back button.
        //setResult(RESULT_CANCELED)

        binding = MyWidgetConfigureBinding.inflate(layoutInflater)
        setContentView(binding.root)

        appWidgetText = binding.appwidgetText as EditText
        binding.addButton.setOnClickListener(onClickListener)

        // Find the widget id from the intent.
        val appWidgetId = intent?.extras?.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID) ?: AppWidgetManager.INVALID_APPWIDGET_ID

        // If this activity was started with an intent without an app widget ID, finish with an error.
        if (appWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
            finish()
            return
        }
        val imageButton = findViewById<ImageButton>(R.id.imageButton)
        val imageButton2 = findViewById<ImageButton>(R.id.imageButton2)
        val imageButton5 = findViewById<ImageButton>(R.id.imageButton5)
        val imageButton6 = findViewById<ImageButton>(R.id.imageButton6)
        imageButton.setOnClickListener {
            color = "FFBB86FC"
        }
        imageButton2.setOnClickListener {
            color = "000000"
        }
        imageButton5.setOnClickListener {
            text_color = "FFFFFF"
        }
        imageButton6.setOnClickListener {
            text_color = "000000"
        }
        val resultValue = Intent()
        resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
        resultValue.putExtra("color", color)
        resultValue.putExtra("text_color", text_color)
        setResult(RESULT_OK, resultValue)

//        val appWidgetManager = AppWidgetManager.getInstance(applicationContext)
//        appWidgetManager.updateAppWidget(appWidgetId, MyWidget.buildRemoteViews(applicationContext, appWidgetId))
//        appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetId, R.id.layout_widget)
//
//        appWidgetText.setText(loadTitlePref(this@MyWidgetConfigureActivity, appWidgetId))
    }

}

private const val PREFS_NAME = "com.example.myapplication.MyWidget"
private const val PREF_PREFIX_KEY = "appwidget_"

// Write the prefix to the SharedPreferences object for this widget
internal fun saveTitlePref(context: Context, appWidgetId: Int, text: String) {
    val prefs = context.getSharedPreferences(PREFS_NAME, 0).edit()
    prefs.putString(PREF_PREFIX_KEY + appWidgetId, text)
    prefs.apply()
}

// Read the prefix from the SharedPreferences object for this widget.
// If there is no preference saved, get the default from a resource
internal fun loadTitlePref(context: Context, appWidgetId: Int): String {
    val prefs = context.getSharedPreferences(PREFS_NAME, 0)
    val titleValue = prefs.getString(PREF_PREFIX_KEY + appWidgetId, null)
    return titleValue ?: context.getString(R.string.appwidget_text)
}

internal fun deleteTitlePref(context: Context, appWidgetId: Int) {
    val prefs = context.getSharedPreferences(PREFS_NAME, 0).edit()
    prefs.remove(PREF_PREFIX_KEY + appWidgetId)
    prefs.apply()
}