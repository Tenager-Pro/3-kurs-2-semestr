package com.example.lr8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
        btnStart.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View) {
                val serviceIntent: Intent = Intent(this@MainActivity, MyService::class.java)
                serviceIntent.putExtra("time", editText.text.toString());
                serviceIntent.putExtra("progress", (seekBar.progress.toFloat()/100).toString());

                val lp = window.attributes
                lp.screenBrightness = (seekBar.progress.toFloat()/100).toFloat()
                window.attributes = lp
                Task((editText.text.toString().toInt()*1000).toLong(), (seekBar.progress.toFloat()/100).toString())
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
    fun Task(time: Long,brightness: String){
        var cTimer: CountDownTimer? = null

        Toast.makeText(this, "Запущено задание", Toast.LENGTH_SHORT).show()

        cTimer = object : CountDownTimer(time, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                System.out.println((millisUntilFinished / 1000).toString())
            }
            override fun onFinish() {
                System.out.println("done")
                val lp = window.attributes
                lp.screenBrightness = ((brightness.toFloat()-20)/100).toFloat()
                window.attributes = lp
            }
        }
        cTimer.start()


    }
}