package com.wzjing.devutil

import android.app.Application
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.PixelFormat
import android.graphics.Point
import android.os.Binder
import android.os.Handler
import android.os.IBinder
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager

class FloatWindowService : Service() {

    override fun onBind(intent: Intent): IBinder = Binder()

    override fun onCreate() {
        super.onCreate()
        Handler(mainLooper).post {
            startFloatView(application)
        }
    }

    private fun startFloatView(app: Application) = app.apply {
        (getSystemService(Context.WINDOW_SERVICE) as? WindowManager)?.apply {
            val params = WindowManager.LayoutParams().apply {
                gravity = Gravity.TOP or Gravity.END
                val size = Point()
                defaultDisplay.getSize(size)
                x = size.x
                y = 500
                format = PixelFormat.TRANSLUCENT
            }
            addView(LayoutInflater.from(app).inflate(R.layout.activity_float, null), params)
        }
    }
}
