package com.softbean.notifriend

import android.content.Context
import com.softbean.notifriend.eating.HungryService
import com.softbean.notifriend.playing.PlayingService

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

        addAction(PendingService(context, PlayingService::class.java, "Play with Nubb").asAction())
        addAction(PendingService(context, SnoozeService::class.java, "Naptime").asAction())
        addAction(PendingService(context, HungryService::class.java, "Eat").asAction())
    }
}