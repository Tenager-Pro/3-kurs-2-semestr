package com.example.lb7_2

import android.app.Activity
import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.example.lb7_2.databinding.MyWidgetConfigureBinding

/**
 * The configuration screen for the [MyWidget] AppWidget.
 */
class MyWidgetConfigureActivity : Activity() {
    var text_color: String = "FFFFFF"
    var color: String = "000000"
    private var appWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID
    private lateinit var appWidgetText_2: EditText
    private lateinit var appWidgetText: EditText
    private var onClickListener = View.OnClickListener {
        val context = this@MyWidgetConfigureActivity

        // When the button is clicked, store the string locally
        val widgetText = appWidgetText.text.toString()
        saveTitlePref(context, appWidgetId, widgetText)

        // It is the responsibility of the configuration activity to update the app widget
        val appWidgetManager = AppWidgetManager.getInstance(context)

        updateAppWidget(context, appWidgetManager, appWidgetId)

        // Make sure we pass back the original appWidgetId
        val resultValue = Intent()
        resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
        setResult(RESULT_OK, resultValue)
        finish()
    }
    private lateinit var binding: MyWidgetConfigureBinding

    public override fun onCreate(icicle: Bundle?) {
        super.onCreate(icicle)

        // Set the result to CANCELED.  This will cause the widget host to cancel
        // out of the widget placement if the user presses the back button.
        setResult(RESULT_CANCELED)

        binding = MyWidgetConfigureBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val resultValue = Intent()
        appWidgetText_2 = binding.appwidgetText2
        appWidgetText = binding.appwidgetText as EditText
        binding.addButton.setOnClickListener(onClickListener)
        val imageButton = findViewById<ImageButton>(R.id.imageButton)
        val imageButton2 = findViewById<ImageButton>(R.id.imageButton2)
        val imageButton5 = findViewById<ImageButton>(R.id.imageButton5)
        val imageButton6 = findViewById<ImageButton>(R.id.imageButton6)
        imageButton.setOnClickListener {
            color = "#FFBB86FC"
            appWidgetText_2.setText("#FFBB86FC")

            resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
            resultValue.putExtra("color", color)
            setResult(RESULT_OK, resultValue)
        }
        imageButton2.setOnClickListener {
            color = "#FF03DAC5"
            appWidgetText.setText("#FF03DAC5")

            resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
            resultValue.putExtra("color", color)
            setResult(RESULT_OK, resultValue)
        }
        imageButton5.setOnClickListener {
            text_color = "#FF6200EE"
            appWidgetText.setText("#FF6200EE")

            resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
            resultValue.putExtra("text_color", text_color)
            setResult(RESULT_OK, resultValue)

        }
        imageButton6.setOnClickListener {
            text_color = "#FF03DAC5"
            appWidgetText.setText("#FF03DAC5")
            resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
            resultValue.putExtra("text_color", text_color)
            Toast.makeText(applicationContext, resultValue.getStringExtra("text_color"), Toast.LENGTH_SHORT).show()
            setResult(RESULT_OK, resultValue)

        }
        // Find the widget id from the intent.
        val intent = intent
        val extras = intent.extras
        if (extras != null) {
            appWidgetId = extras.getInt(
                AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID
            )
        }

        // If this activity was started with an intent without an app widget ID, finish with an error.
        if (appWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
            finish()
            return
        }

        appWidgetText.setText(loadTitlePref(this@MyWidgetConfigureActivity, appWidgetId))
    }

}

private const val PREFS_NAME = "com.example.lb7_2.MyWidget"
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
internal fun loadTitleColor(context: Context, appWidgetId: Int): String {
    val prefs = context.getSharedPreferences(PREFS_NAME, 0)
    val titleValue = prefs.getString(PREF_PREFIX_KEY + appWidgetId, null)
    return titleValue ?: context.getString(R.string.appwidget_text)
}


internal fun deleteTitlePref(context: Context, appWidgetId: Int) {
    val prefs = context.getSharedPreferences(PREFS_NAME, 0).edit()
    prefs.remove(PREF_PREFIX_KEY + appWidgetId)
    prefs.apply()
}