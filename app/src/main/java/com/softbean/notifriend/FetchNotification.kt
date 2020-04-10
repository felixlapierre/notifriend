package com.softbean.notifriend

import android.content.Context

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