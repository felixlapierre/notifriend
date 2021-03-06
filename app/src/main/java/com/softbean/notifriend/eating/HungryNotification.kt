package com.softbean.notifriend.eating

import android.content.Context
import com.softbean.notifriend.*

class HungryNotification constructor(context: Context, drawableId: Int) : Notification(context) {
    init {
        title = "Nubb is hungry..."
        text = "He wants something to eat!"
        largeIconId = R.drawable.smolnubb

        val bigStyle = BigPictureStyle(context)
        bigStyle.bigContentTitle = "I'm hungry!!"
        bigStyle.summaryText = "Gimme something good to eat..."
        bigStyle.bigPictureDrawableId = drawableId
        style = bigStyle

        addAction(PendingService(context, MarshmallowService::class.java, "Marshmallow").asAction())
        addAction(PendingService(context, OnigiriService::class.java, "Onigiri").asAction())
        addAction(PendingService(context, IntroService::class.java, "Done Eating").asAction())
        addAction(PendingService(context, SnoozeService::class.java, "Snooze").asAction())
    }
}