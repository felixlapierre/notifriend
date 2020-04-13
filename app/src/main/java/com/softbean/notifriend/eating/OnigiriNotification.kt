package com.softbean.notifriend.eating

import android.content.Context
import com.softbean.notifriend.BigPictureStyle
import com.softbean.notifriend.Notification
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
    }
}