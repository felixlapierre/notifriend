package com.softbean.notifriend

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.icu.util.Calendar
import android.os.SystemClock
import androidx.core.app.NotificationCompat
import kotlin.random.Random

class PendingService constructor(
    private val context: Context,
    private val target: Class<out Any>,
    private val title: String
) {
    fun asIntent(): PendingIntent {
        val snoozeIntent = Intent(context, target)
        snoozeIntent.action = target.name
        return PendingIntent.getService(context, 0, snoozeIntent, PendingIntent.FLAG_ONE_SHOT)
    }

    fun asAction(): NotificationCompat.Action {
        val pendingIntent = asIntent()
        return NotificationCompat.Action.Builder(
            R.drawable.ic_small_nubb,
            title,
            pendingIntent
        )
            .build()
    }

    fun delay(millis: Int) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as? AlarmManager

        alarmManager?.set(
            AlarmManager.ELAPSED_REALTIME,
            SystemClock.elapsedRealtime() + millis,
            asIntent()
        )
    }

    fun delayRandomBetween(minMinutes: Int, maxMinutes: Int) {
        val delayMinutes = Random.nextInt(minMinutes, maxMinutes)
        delay(delayMinutes * 60 * 1000)
    }

    fun delayUntilMorning() {
        val currentTimeMillis = Calendar.getInstance().timeInMillis
        val tomorrow = java.util.Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            set(java.util.Calendar.HOUR_OF_DAY, 9)
        }
        val delayTime = tomorrow.timeInMillis - currentTimeMillis

        delay(delayTime.toInt())
    }

    fun repeatDailyAt(hourOfDay: Int) {
        val calendar = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            set(Calendar.HOUR_OF_DAY, hourOfDay)
        }

        val manager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        manager.setInexactRepeating(
            AlarmManager.RTC,
            calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY,
            asIntent()
        )
    }
}