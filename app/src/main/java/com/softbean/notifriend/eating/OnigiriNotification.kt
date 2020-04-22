package com.softbean.notifriend.eating

import android.content.Context
import com.softbean.notifriend.*

class OnigiriNotification constructor(context: Context, drawableId: Int) : Notification(context) {
    init {
        title = "Nubb is eating"
        text = "You gave him onigiri"
        subtext = "Nubb's space"
        largeIconId = R.drawable.smolnubb

        val bigStyle = BigPictureStyle(context)
        bigStyle.bigContentTitle = "Onigiri!?"
        bigStyle.summaryText = "I love it!!"
        bigStyle.bigPictureDrawableId = drawableId
        style = bigStyle

        addAction(PendingService(context, OnigiriService::class.java, "Another").asAction())
        addAction(PendingService(context, HungryService::class.java, "Back").asAction())
        addAction(PendingService(context, IntroService::class.java, "Done Eating").asAction())
    }
}