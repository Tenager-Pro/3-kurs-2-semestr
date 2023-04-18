package com.example.myapplication

import android.app.Activity
import android.appwidget.AppWidgetManager
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup


class ConfigActivity : Activity() {
    var widgetID = AppWidgetManager.INVALID_APPWIDGET_ID
    var resultValue: Intent? = null
    val LOG_TAG = "myLogs"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LOG_TAG, "onCreate config")

        // извлекаем ID конфигурируемого виджета
        val intent = intent
        val extras = intent.extras
        if (extras != null) {
            widgetID = extras.getInt(
                AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID
            )
        }
        // и проверяем его корректность
        if (widgetID == AppWidgetManager.INVALID_APPWIDGET_ID) {
            finish()
        }

        // формируем intent ответа
        resultValue = Intent()
        resultValue!!.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetID)

        // отрицательный ответ
        setResult(RESULT_CANCELED, resultValue)
        setContentView(R.layout.config)
    }

    fun onClick(v: View?) {
        val selRBColor = (findViewById<View>(R.id.rgColor) as RadioGroup)
            .checkedRadioButtonId
        var color = Color.RED
        when (selRBColor) {
            R.id.radioRed -> color = Color.parseColor("#66ff0000")
            R.id.radioGreen -> color = Color.parseColor("#6600ff00")
            R.id.radioBlue -> color = Color.parseColor("#660000ff")
        }
        val etText = findViewById<View>(R.id.etText) as EditText

        // Записываем значения с экрана в Preferences
        val sp = getSharedPreferences(WIDGET_PREF, MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString(
            WIDGET_TEXT + widgetID, etText.text
                .toString()
        )
        editor.putInt(WIDGET_COLOR + widgetID, color)
        editor.commit()

        // положительный ответ
        setResult(RESULT_OK, resultValue)
        Log.d(LOG_TAG, "finish config $widgetID")
        finish()
    }

    companion object {
        const val WIDGET_PREF = "widget_pref"
        const val WIDGET_TEXT = "widget_text_"
        const val WIDGET_COLOR = "widget_color_"
    }
}