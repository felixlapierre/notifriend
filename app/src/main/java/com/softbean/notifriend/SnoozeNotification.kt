package com.softbean.notifriend

import android.content.Context

class SnoozeNotification constructor(context: Context): Notification(context) {
    init {
        title = "Your lad just woke up!"
        text = "He misses you!"
        subtext = "Nubb's space"
        largeIconId = R.drawable.smolnubb

        val bigStyle = BigPictureStyle(context)
        bigStyle.bigContentTitle = "Hi!"
        bigStyle.summaryText = "I had a nice nap!"
        bigStyle.bigPictureDrawableId = R.drawable.samplenubb
        style = bigStyle
    }
}