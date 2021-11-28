package com.skooldio.android.fundamentals.workshop.pomodoro

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.skooldio.android.fundamentals.workshop.pomodoro.databinding.ActivityTimerBinding

class TimerActivity : AppCompatActivity() {
    companion object {
        private const val EXTRA_CONFIG = "config"

        fun newIntent(
            context: Context,
            config: Config
        ): Intent {
            return Intent(context, TimerActivity::class.java).apply {
                putExtra(EXTRA_CONFIG, config)
            }
        }
    }

    private val binding: ActivityTimerBinding by lazy {
        ActivityTimerBinding.inflate(layoutInflater)
    }

    private var config: Config? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        restoreBundle()
    }

    private fun restoreBundle() {
        config = intent.getParcelableExtra(EXTRA_CONFIG)
    }
}
