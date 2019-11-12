package com.wzjing.devutil

import android.app.Application
import android.content.Context
import android.content.Intent
import android.graphics.PixelFormat
import android.graphics.Point
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
                x = size.x
                y = 500
                format = PixelFormat.TRANSLUCENT
            }
            addView(LayoutInflater.from(this@MainActivity).inflate(R.layout.activity_float, null), params)
        }
    }

}
