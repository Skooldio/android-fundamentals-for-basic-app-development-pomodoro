package com.skooldio.android.fundamentals.workshop.pomodoro

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.skooldio.android.fundamentals.workshop.pomodoro.config.NotificationConfig
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

    private fun showNotification(title: String, text: String) {
        val notification = NotificationCompat.Builder(this, NotificationConfig.CHANNEL_ID).apply {
            setContentTitle(title)
            setContentText(text)
            setSmallIcon(R.drawable.ic_notification)
        }.build()
        val manager = NotificationManagerCompat.from(this)
        manager.notify(0, notification)
    }
}
