package com.skooldio.android.fundamentals.workshop.pomodoro

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.skooldio.android.fundamentals.workshop.pomodoro.data.PomodoroCounter
import com.skooldio.android.fundamentals.workshop.pomodoro.databinding.ActivityTimerBinding

class TimerActivity : AppCompatActivity() {
    companion object {
        private const val EXTRA_WORK_DURATION = "work_duration"
        private const val EXTRA_SHORT_BREAK_DURATION = "short_break_duration"
        private const val EXTRA_LONG_BREAK_DURATION = "long_break_duration"

        fun newIntent(
            context: Context,
            workDuration: Int,
            shortBreakDuration: Int,
            longBreakDuration: Int
        ): Intent {
            return Intent(context, TimerActivity::class.java).apply {
                putExtra(EXTRA_WORK_DURATION, workDuration)
                putExtra(EXTRA_SHORT_BREAK_DURATION, shortBreakDuration)
                putExtra(EXTRA_LONG_BREAK_DURATION, longBreakDuration)
            }
        }
    }

    private val binding: ActivityTimerBinding by lazy {
        ActivityTimerBinding.inflate(layoutInflater)
    }

    private var workDuration: Int = 0
    private var shortBreakDuration: Int = 0
    private var longBreakDuration: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        restoreBundle()
    }

    private fun restoreBundle() {
        workDuration = intent.getIntExtra(EXTRA_WORK_DURATION, 0)
        shortBreakDuration = intent.getIntExtra(EXTRA_SHORT_BREAK_DURATION, 0)
        longBreakDuration = intent.getIntExtra(EXTRA_LONG_BREAK_DURATION, 0)
    }
}
