package com.softbean.notifriend.eating

import android.content.Context
import androidx.core.app.NotificationCompat
import com.softbean.notifriend.BigPictureStyle
import com.softbean.notifriend.Notification
import com.softbean.notifriend.PendingService
import com.softbean.notifriend.R

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
    }
}