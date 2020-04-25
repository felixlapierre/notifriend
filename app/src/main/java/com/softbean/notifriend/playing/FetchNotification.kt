package com.softbean.notifriend.playing

import android.content.Context
import com.softbean.notifriend.*

class FetchNotification constructor(context: Context, drawableId: Int) : GameNotification(context) {
    init {
        title = "Nubb is ready to play!"
        text = ""
        largeIconId = R.drawable.smolnubb

        val bigStyle = BigPictureStyle(context)
        bigStyle.bigContentTitle = "Nubb is fetching the ball..."
        bigStyle.bigPictureDrawableId = drawableId
        style = bigStyle
    }
}