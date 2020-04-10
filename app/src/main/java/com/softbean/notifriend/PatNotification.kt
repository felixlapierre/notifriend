package com.softbean.notifriend

import android.content.Context

class PatNotification constructor(context: Context) : Notification(context) {
    init {
        title = "You pat nubb!"
        text = "UwU"
        subtext = "Nubb's space"
        largeIconId = R.drawable.smolnubb

        val bigStyle = BigPictureStyle(context)
        bigStyle.bigContentTitle = "I love pats!"
        bigStyle.bigPictureDrawableId = R.drawable.nubbounce
        style = bigStyle
    }
}