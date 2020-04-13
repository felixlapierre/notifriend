package com.softbean.notifriend.playing

import android.content.Context
import com.softbean.notifriend.BigPictureStyle
import com.softbean.notifriend.Notification
import com.softbean.notifriend.R

class PlayingNotification constructor(context: Context, drawableId: Int) : Notification(context) {
    init {
        title = "Nubb wants to play!"
        text = "He's getting excited..."
        subtext = "Nubb's space"
        largeIconId = R.drawable.smolnubb

        val bigStyle = BigPictureStyle(context)
        bigStyle.bigContentTitle = "Play with me!!"
        bigStyle.bigPictureDrawableId = drawableId
        style = bigStyle
    }
}