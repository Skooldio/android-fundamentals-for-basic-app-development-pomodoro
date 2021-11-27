package com.skooldio.android.fundamentals.workshop.pomodoro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    companion object {
        private const val DEFAULT_WORK_DURATION = 25
        private const val DEFAULT_SHORT_BREAK_DURATION = 5
        private const val DEFAULT_LONG_BREAK_DURATION = 25
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}