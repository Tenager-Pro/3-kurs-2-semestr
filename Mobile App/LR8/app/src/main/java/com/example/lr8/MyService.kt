package com.example.lr8

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.CountDownTimer
import android.os.IBinder
import android.provider.Settings
import android.util.Log
import android.view.WindowManager
import android.widget.Toast


class MyService : Service() {
    val LOG_TAG = "myLogs"


    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onRebind(intent: Intent?) {
        super.onRebind(intent)
        Log.d(LOG_TAG, "MyService onRebind")
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d(LOG_TAG, "MyService onUnbind")
        return super.onUnbind(intent)
    }

    override fun onCreate() {
        super.onCreate()
        Toast.makeText(this, "Служба создана", Toast.LENGTH_SHORT).show()
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        Toast.makeText(this, "Служба запущена", Toast.LENGTH_SHORT).show()
        val time = intent.getStringExtra("time")
        val sysBackLightValue = intent.getStringExtra("progress")
        Task((time!!.toInt()*1000).toLong(),sysBackLightValue.toString())

        return super.onStartCommand(intent, flags, startId)
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
            }
        }
        cTimer.start()


    }
}