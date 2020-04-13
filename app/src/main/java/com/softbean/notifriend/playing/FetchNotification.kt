package com.softbean.notifriend.playing

import android.content.Context
import com.softbean.notifriend.BigPictureStyle
import com.softbean.notifriend.Notification
import com.softbean.notifriend.R

class FetchNotification constructor(context: Context, drawableId: Int) : Notification(context) {
    init {
        title = "Nubb is ready to play!"
        text = ""
        subtext = "Nubb's space"
        largeIconId = R.drawable.smolnubb

        val bigStyle = BigPictureStyle(context)
        bigStyle.bigContentTitle = "Nubb is fetching the ball..."
        bigStyle.bigPictureDrawableId = drawableId
        style = bigStyle
    }
}