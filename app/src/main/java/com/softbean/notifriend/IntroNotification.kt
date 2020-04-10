package com.softbean.notifriend

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat

class IntroNotification constructor(context: Context) : Notification(context) {
    init {
        title = "Your lad wants to talk to you!"
        text = "He thinks you're doing great!"
        subtext = "Nubb's space"
        largeIconId = R.drawable.smolnubb

        val bigStyle = BigPictureStyle(context)
        bigStyle.bigContentTitle = "Hi!"
        bigStyle.summaryText = "I love you!"
        bigStyle.bigPictureDrawableId = R.drawable.samplenubb
        style = bigStyle

        addAction(Action(context, PatService::class.java, "Pat Nubb").build())
        addAction(Action(context, SnoozeService::class.java, "Naptime").build())
    }
}