package com.softbean.notifriend.playing

import android.content.Context
import com.softbean.notifriend.*

class PatNotification constructor(context: Context,  drawableId: Int) : GameNotification(context) {
    init {
        title = "You pat nubb!"
        text = "UwU"
        largeIconId = R.drawable.smolnubb

        val bigStyle = BigPictureStyle(context)
        bigStyle.bigContentTitle = "I love pats!"
        bigStyle.bigPictureDrawableId = drawableId
        style = bigStyle

    }
}
