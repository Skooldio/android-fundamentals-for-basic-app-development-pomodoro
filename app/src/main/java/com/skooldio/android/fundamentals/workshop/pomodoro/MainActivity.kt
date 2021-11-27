package com.skooldio.android.fundamentals.workshop.pomodoro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.skooldio.android.fundamentals.workshop.pomodoro.databinding.ActivityMainBinding

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

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var workDuration = WORK_DURATION_DEFAULT
    private var shortBreakDuration = SHORT_BREAK_DURATION_DEFAULT
    private var longBreakDuration = LONG_BREAK_DURATION_DEFAULT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupView()
    }

    private fun setupView() {
        updateWorkDuration()
        updateShortBreakDuration()
        updateLongBreakDuration()

        binding.buttonAddWorkDuration.setOnClickListener {
            workDuration += 5
            workDuration = workDuration.coerceIn(WORK_DURATION_MIN, WORK_DURATION_MAX)
            updateWorkDuration()
        }
        binding.buttonReduceWorkDuration.setOnClickListener {
            workDuration -= 5
            workDuration = workDuration.coerceIn(WORK_DURATION_MIN, WORK_DURATION_MAX)
            updateWorkDuration()
        }

        binding.buttonAddShortBreakDuration.setOnClickListener {
            shortBreakDuration += 5
            shortBreakDuration = shortBreakDuration.coerceIn(SHORT_BREAK_DURATION_MIN, SHORT_BREAK_DURATION_MAX)
            updateShortBreakDuration()
        }
        binding.buttonReduceShortBreakDuration.setOnClickListener {
            shortBreakDuration -= 5
            shortBreakDuration = shortBreakDuration.coerceIn(SHORT_BREAK_DURATION_MIN, SHORT_BREAK_DURATION_MAX)
            updateShortBreakDuration()
        }

        binding.buttonAddLongBreakDuration.setOnClickListener {
            longBreakDuration += 5
            longBreakDuration = longBreakDuration.coerceIn(LONG_BREAK_DURATION_MIN, LONG_BREAK_DURATION_MAX)
            updateLongBreakDuration()
        }
        binding.buttonReduceLongBreakDuration.setOnClickListener {
            longBreakDuration -= 5
            longBreakDuration = longBreakDuration.coerceIn(LONG_BREAK_DURATION_MIN, LONG_BREAK_DURATION_MAX)
            updateLongBreakDuration()
        }

        binding.buttonReady.setOnClickListener {

        }
    }

    private fun updateWorkDuration() {
        binding.textViewWorkDuration.text = getString(R.string.duration_value, workDuration)
    }

    private fun updateShortBreakDuration() {
        binding.textViewShortDuration.text = getString(R.string.duration_value, shortBreakDuration)
    }

    private fun updateLongBreakDuration() {
        binding.textViewLongDuration.text = getString(R.string.duration_value, longBreakDuration)
    }
}
