package com.softbean.notifriend

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat

class Action constructor(private val context: Context, private val target: Class<out Any>, private val title: String) {
    fun build(): NotificationCompat.Action {
        val snoozeIntent = Intent(context, target)
        snoozeIntent.action = target.name
        var snoozePendingIntent = PendingIntent.getService(context, 0, snoozeIntent, PendingIntent.FLAG_ONE_SHOT)
        return NotificationCompat.Action.Builder(
            R.drawable.ic_small_nubb,
            title,
            snoozePendingIntent)
            .build()
    }
}