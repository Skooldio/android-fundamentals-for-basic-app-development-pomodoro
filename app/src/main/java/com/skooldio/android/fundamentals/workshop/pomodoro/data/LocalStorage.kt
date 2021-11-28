package com.skooldio.android.fundamentals.workshop.pomodoro.data

import android.content.Context
import androidx.core.content.edit

object LocalStorage {
    private const val PREFERENCES_NAME = "local_storage"
    private const val KEY_WORK_DURATION = "work_duration"
    private const val KEY_SHORT_BREAK_DURATION = "short_break_duration"
    private const val KEY_LONG_BREAK_DURATION = "long_break_duration"

    fun saveConfig(
        context: Context,
        workDuration: Int,
        shortBreakDuration: Int,
        longBreakDuration: Int
    ) {
        context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE).edit {
            putInt(KEY_WORK_DURATION, workDuration)
            putInt(KEY_SHORT_BREAK_DURATION, shortBreakDuration)
            putInt(KEY_LONG_BREAK_DURATION, longBreakDuration)
        }
    }

    fun getConfig(
        context: Context
    ): Triple<Int, Int, Int> {
        val preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
        val workDuration = preferences.getInt(KEY_WORK_DURATION, 25)
        val shortBreak = preferences.getInt(KEY_SHORT_BREAK_DURATION, 5)
        val longBreak = preferences.getInt(KEY_LONG_BREAK_DURATION, 25)
        return Triple(workDuration, shortBreak, longBreak)
    }
}