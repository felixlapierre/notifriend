package com.softbean.notifriend

import android.content.Context
import com.softbean.notifriend.eating.HungryService
import com.softbean.notifriend.playing.PlayingService

class IntroNotification constructor(context: Context) : Notification(context) {
    init {
        title = "Notifriend has been started."
        text = "Thank you for using notifriend!"
        subtext = "Nubb's space"
        largeIconId = R.drawable.smolnubb

        val bigStyle = BigPictureStyle(context)
        bigStyle.bigContentTitle = "Thank you for using Notifriend!"
        bigStyle.summaryText = "Nubb will let you know when he wants attention!"
        bigStyle.bigPictureDrawableId = R.drawable.samplenubb
        style = bigStyle

        addAction(PendingService(context, PlayingService::class.java, "Play").asAction())
        addAction(PendingService(context, HungryService::class.java, "Feed").asAction())
        addAction(PendingService(context, SnoozeService::class.java, "Sleep").asAction())
    }
}