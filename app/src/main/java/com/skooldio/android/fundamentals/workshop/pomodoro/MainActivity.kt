package com.skooldio.android.fundamentals.workshop.pomodoro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.skooldio.android.fundamentals.workshop.pomodoro.config.PomodoroConfig

class MainActivity : AppCompatActivity() {
    companion object {
        private const val WORK_DURATION_DEFAULT = PomodoroConfig.WORK_DURATION_DEFAULT
        private const val WORK_DURATION_MIN = PomodoroConfig.WORK_DURATION_MIN
        private const val WORK_DURATION_MAX = PomodoroConfig.WORK_DURATION_MAX

        private const val SHORT_BREAK_DURATION_DEFAULT = PomodoroConfig.SHORT_BREAK_DURATION_DEFAULT
        private const val SHORT_BREAK_DURATION_MIN = PomodoroConfig.SHORT_BREAK_DURATION_MIN
        private const val SHORT_BREAK_DURATION_MAX = PomodoroConfig.SHORT_BREAK_DURATION_MAX

        private const val LONG_BREAK_DURATION_DEFAULT = PomodoroConfig.LONG_BREAK_DURATION_DEFAULT
        private const val LONG_BREAK_DURATION_MIN = PomodoroConfig.LONG_BREAK_DURATION_MIN
        private const val LONG_BREAK_DURATION_MAX = PomodoroConfig.LONG_BREAK_DURATION_MAX
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}