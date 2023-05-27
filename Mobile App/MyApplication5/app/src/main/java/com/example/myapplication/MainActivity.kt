package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {

    var timer: Timer = Timer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        title = "SwipeRefreshLayout"
        val btnStart = findViewById<Button>(R.id.button_start)
        val btnStop = findViewById<Button>(R.id.button_stop)
        val seekBar: SeekBar = findViewById(R.id.seekBar)

        val editText: EditText = findViewById(R.id.editText)
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {    }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {     }
        })
        // запуск службы
        btnStart.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View) {
                var cTimer: CountDownTimer? = null
                val serviceIntent: Intent = Intent(this@MainActivity, MyService::class.java)

                serviceIntent.putExtra("time", editText.text.toString());
                serviceIntent.putExtra("progress", (seekBar.progress.toFloat()/100).toString());

                val lp = window.attributes
                lp.screenBrightness = (seekBar.progress.toFloat()/100).toFloat()
                window.attributes = lp

                cTimer = object : CountDownTimer((editText.text*1000).toLong(), 1000) {
                    override fun onTick(millisUntilFinished: Long) {
                        System.out.println((millisUntilFinished / 1000).toString())
                    }
                    override fun onFinish() {
                        lp.screenBrightness = ((seekBar.progress.toFloat()-10)/100)
                    }
                }
                cTimer.start()
        // используем явный вызов службы
                startService(serviceIntent)
            }
        })
        // остановка службы
        btnStop.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View) {
                stopService(Intent(this@MainActivity, MyService::class.java))
            }
        })
    }


}