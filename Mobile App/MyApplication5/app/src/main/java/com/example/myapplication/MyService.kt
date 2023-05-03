package com.example.myapplication

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.provider.Settings
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
        val sysBackLightValue = intent.getStringExtra("progress")
        val brightnessInt = (sysBackLightValue!!.toFloat()*255)

        Settings.System.putInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS_MODE, Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
        Settings.System.putInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS, brightnessInt!!.toInt());


        Toast.makeText(this, sysBackLightValue, Toast.LENGTH_SHORT).show()
        return START_STICKY

    }
    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "Служба остановлена", Toast.LENGTH_SHORT).show()
    }

}
val Context.brightness:Int
    get() {
        return Settings.System.getInt(
            this.contentResolver,
            Settings.System.SCREEN_BRIGHTNESS,
            0
        )
    }
val Context.canWrite:Boolean
    get() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return Settings.System.canWrite(this)
        }else{
            return true
        }
    }
// Extension method to set screen brightness programmatically
fun Context.setBrightness(value:Int):Unit{
    Settings.System.putInt(
        this.contentResolver,
        Settings.System.SCREEN_BRIGHTNESS,
        value
    )
}