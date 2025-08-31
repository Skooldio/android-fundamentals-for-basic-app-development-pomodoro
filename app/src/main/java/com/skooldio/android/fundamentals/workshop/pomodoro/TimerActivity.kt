package com.skooldio.android.fundamentals.workshop.pomodoro

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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
        // Additional code to support edge-to-edge in Android 15
        // Leave this code above the setContentView method
        enableEdgeToEdge()
        setContentView(binding.root)

        // Additional code to support edge-to-edge in Android 15
        // Leave this code below the setContentView method
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        restoreBundle()
    }

    private fun restoreBundle() {
        config = intent.getParcelableExtra(EXTRA_CONFIG)
    }
}
