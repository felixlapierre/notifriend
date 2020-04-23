package com.softbean.notifriend

import android.content.Context
import com.softbean.notifriend.eating.HungryService
import com.softbean.notifriend.playing.PlayingService
import java.lang.Math.random
import java.lang.Math.toIntExact
import kotlin.math.ceil

class IntroNotification constructor(context: Context) : Notification(context) {
    init {
        title = "Stop by when you have time!"
        text = "Nubb is hanging out"
        largeIconId = R.drawable.smolnubb

        val bigStyle = BigPictureStyle(context)
        bigStyle.bigContentTitle = "Hi!!"
        bigStyle.summaryText = "I missed you!"
        bigStyle.bigPictureDrawableId = R.drawable.nubbroom
        style = bigStyle

        addAction(PendingService(context, PlayingService::class.java, "Play").asAction())
        addAction(PendingService(context, HungryService::class.java, "Feed").asAction())
        addAction(PendingService(context, SnoozeService::class.java, "Sleep").asAction())
    }
}