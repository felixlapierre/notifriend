package com.softbean.notifriend.playing

import android.content.Context
import com.softbean.notifriend.BigPictureStyle
import com.softbean.notifriend.Notification
import com.softbean.notifriend.R

class PatNotification constructor(context: Context,  drawableId: Int) : Notification(context) {
    init {
        title = "You pat nubb!"
        text = "UwU"
        subtext = "Nubb's space"
        largeIconId = R.drawable.smolnubb

        val bigStyle = BigPictureStyle(context)
        bigStyle.bigContentTitle = "I love pats!"
        bigStyle.bigPictureDrawableId = drawableId
        style = bigStyle
    }
}