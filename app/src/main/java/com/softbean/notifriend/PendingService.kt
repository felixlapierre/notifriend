package com.softbean.notifriend

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.SystemClock
import androidx.core.app.NotificationCompat

class PendingService constructor(private val context: Context, private val target: Class<out Any>, private val title: String) {
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
            pendingIntent)
            .build()
    }

    fun delay(millis: Int) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as? AlarmManager

        alarmManager?.set(
            AlarmManager.ELAPSED_REALTIME_WAKEUP,
            SystemClock.elapsedRealtime() + millis,
            asIntent()
        )
    }
}