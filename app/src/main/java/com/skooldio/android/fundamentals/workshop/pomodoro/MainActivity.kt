package com.skooldio.android.fundamentals.workshop.pomodoro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    companion object {
        private const val WORK_DURATION_DEFAULT = 25
        private const val WORK_DURATION_MIN = 20
        private const val WORK_DURATION_MAX = 40

        private const val SHORT_BREAK_DURATION_DEFAULT = 5
        private const val SHORT_BREAK_DURATION_MIN = 5
        private const val SHORT_BREAK_DURATION_MAX = 15

        private const val LONG_BREAK_DURATION_DEFAULT = 25
        private const val LONG_BREAK_DURATION_MIN = 20
        private const val LONG_BREAK_DURATION_MAX = 30
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}