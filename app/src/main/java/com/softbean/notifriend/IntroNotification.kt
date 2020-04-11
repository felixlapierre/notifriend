package com.softbean.notifriend

import android.content.Context

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

        addAction(PendingService(context, PatService::class.java, "Pat Nubb").asAction())
        addAction(PendingService(context, SnoozeService::class.java, "Naptime").asAction())
        addAction(PendingService(context, FetchService::class.java, "Fetch").asAction())
    }
}