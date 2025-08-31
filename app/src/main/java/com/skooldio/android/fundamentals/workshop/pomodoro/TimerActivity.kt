package com.skooldio.android.fundamentals.workshop.pomodoro

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.skooldio.android.fundamentals.workshop.pomodoro.databinding.ActivityTimerBinding
import com.skooldio.android.fundamentals.workshop.pomodoro.Config

class TimerActivity : AppCompatActivity() {

    companion object {
//        private const val EXTRA_WORK_DURATION = "work_duration"
//        private const val EXTRA_SHORT_BREAK_DURATION = "short_break_duration"
//        private const val EXTRA_LONG_BREAK_DURATION = "long_break_duration"
          private const val EXTRA_CONFIG = "config"
        fun newIntent(
              context: Context,
//            workDuration: Int,
//            shortBreakDuration: Int,
//            longBreakDuration: Int
            config: Config
        ): Intent {
            return Intent(context, TimerActivity::class.java).apply {
//                putExtra(EXTRA_WORK_DURATION, workDuration)
//                putExtra(EXTRA_SHORT_BREAK_DURATION, shortBreakDuration)
//                putExtra(EXTRA_LONG_BREAK_DURATION, longBreakDuration)
                putExtra(EXTRA_CONFIG, config)
            }
        }
    }
    private val binding: ActivityTimerBinding by lazy {
        ActivityTimerBinding.inflate(layoutInflater)
    }

//    private var workDuration: Int = 0
//    private var shortBreakDuration: Int = 0
//    private var longBreakDuration: Int = 0
      private var config: Config? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        restoreBundle()
        if (config == null) {
            // Handle error - config wasn't passed properly
            finish()
            return
        }

    }

    private fun restoreBundle() {
//        workDuration = intent.getIntExtra(EXTRA_WORK_DURATION,0)
//        shortBreakDuration = intent.getIntExtra(EXTRA_SHORT_BREAK_DURATION,0)
//        longBreakDuration = intent.getIntExtra(EXTRA_LONG_BREAK_DURATION, 0)
        config = intent.getParcelableExtra(EXTRA_CONFIG)
    }
}