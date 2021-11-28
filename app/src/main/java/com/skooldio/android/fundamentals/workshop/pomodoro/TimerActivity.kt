package com.skooldio.android.fundamentals.workshop.pomodoro

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.skooldio.android.fundamentals.workshop.pomodoro.config.NotificationConfig
import com.skooldio.android.fundamentals.workshop.pomodoro.data.PomodoroCounter
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

    private val pomodoroCounter = PomodoroCounter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        restoreBundle()
        setupView()
        setupPomodoroCounter()
    }

    private fun restoreBundle() {
        config = intent.getParcelableExtra(EXTRA_CONFIG)
    }

    private fun setupView() {
        binding.buttonPlay.setOnClickListener {
            binding.buttonPlay.visibility = View.GONE
            binding.buttonPause.visibility = View.VISIBLE
            pomodoroCounter.play()
        }
        binding.buttonPause.setOnClickListener {
            binding.buttonPlay.visibility = View.VISIBLE
            binding.buttonPause.visibility = View.GONE
            pomodoroCounter.pause()
        }
        binding.buttonFastForward.setOnClickListener {
            binding.buttonPlay.visibility = View.VISIBLE
            binding.buttonPause.visibility = View.GONE
            pomodoroCounter.fastForward()
        }
    }

    private fun setupPomodoroCounter() {
        config?.let {
            pomodoroCounter.apply {
                config(
                    workDuration = it.workDuration,
                    shortBreakDuration = it.shortBreakDuration,
                    longBreakDuration = it.longBreakDuration
                )
                setListener(
                    onReady = { minute, second -> updateCounterStatus(State.Ready, minute, second) },
                    onWork = { minute, second -> updateCounterStatus(State.Work, minute, second) },
                    onShortBreak = { minute, second -> updateCounterStatus(State.ShortBreak, minute, second) },
                    onLongBreak = { minute, second -> updateCounterStatus(State.LongBreak, minute, second) }
                )
            }
        }
    }

    private fun updateCounterStatus(state: State, minute: Int, second: Int) {
        binding.textViewState.setText(getStateTextResourceId(state))
        binding.textViewMinute.text = getString(R.string.time_value, minute)
        binding.textViewSecond.text = getString(R.string.time_value, second)
        if (minute == 0 && second == 0) {
            onPomodoroCounterFinished(state)
        }
    }

    private fun getStateTextResourceId(state: State): Int {
        return when (state) {
            is State.Ready -> R.string.ready
            is State.Work -> R.string.state_work
            is State.ShortBreak -> R.string.state_short_break
            is State.LongBreak -> R.string.state_long_break
        }
    }

    private fun onPomodoroCounterFinished(state: State) {
        binding.buttonPlay.visibility = View.VISIBLE
        binding.buttonPause.visibility = View.GONE
        when (state) {
            State.Work -> showNotification(
                title = getString(R.string.notification_time_up_title),
                text = getString(R.string.notification_time_up_text_work)
            )
            State.ShortBreak -> showNotification(
                title = getString(R.string.notification_time_up_title),
                text = getString(R.string.notification_time_up_text_short_break)
            )
            State.LongBreak -> showNotification(
                title = getString(R.string.notification_time_up_title),
                text = getString(R.string.notification_time_up_text_long_break)
            )
            State.Ready -> {}
        }
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

    sealed class State {
        object Ready : State()
        object Work : State()
        object ShortBreak : State()
        object LongBreak : State()
    }
}
