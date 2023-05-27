package com.example.myapplication

import android.app.PendingIntent.getActivity
import android.app.Service
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.CountDownTimer
import android.os.IBinder
import android.provider.Settings
import android.view.View
import android.view.WindowManager
import android.widget.Toast


class MyService : Service() {

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Toast.makeText(this, "Служба создана", Toast.LENGTH_SHORT).show()
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val time = intent.getStringExtra("time")
        val sysBackLightValue = intent.getStringExtra("progress")
        Task((time!!.toInt()*1000).toLong(),sysBackLightValue.toString())

        System.out.println((time!!.toInt()*1000).toLong())
        Toast.makeText(this, sysBackLightValue, Toast.LENGTH_SHORT).show()
        return START_STICKY

    }
    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "Служба остановлена", Toast.LENGTH_SHORT).show()
    }

    fun Task(time: Long,brightness: String){
        var cTimer: CountDownTimer? = null

        val brightnessInt = ((brightness.toFloat() * 255)-20).toInt()
        Toast.makeText(this, "Запущено задание", Toast.LENGTH_SHORT).show()

        cTimer = object : CountDownTimer(time, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                System.out.println((millisUntilFinished / 1000).toString())
            }
            override fun onFinish() {
                System.out.println("done")
                System.out.println(brightnessInt.toString())
                val layoutParams = WindowManager.LayoutParams()
                val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
                val currentBrightness = Settings.System.getInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS)



            }
        }
        cTimer.start()


    }

}
