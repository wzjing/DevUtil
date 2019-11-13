package com.wzjing.devutil

import android.app.Application
import android.content.Context
import android.content.Intent
import android.graphics.PixelFormat
import android.graphics.Point
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.LayoutInflater
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        Handler().postDelayed({
            startFloatView()
        }, 1000)

    }

    private fun startFloatView() = this.apply {
        (getSystemService(Context.WINDOW_SERVICE) as? WindowManager)?.apply {
            val params = WindowManager.LayoutParams().apply {
                gravity = Gravity.TOP or Gravity.END
                val size = Point()
                defaultDisplay.getSize(size)
                type =
                    if (Build.VERSION.SDK_INT >= 28) WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
                    else WindowManager.LayoutParams.TYPE_PHONE
                x =  200
                y = 500
                width = 300
                height = 200
                format = PixelFormat.RGBA_8888
                flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
            }
            val view = LayoutInflater.from(this@MainActivity).inflate(R.layout.activity_float, null)
            addView(view, params)
        }
    }

}
