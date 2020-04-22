package com.softbean.notifriend.playing

import android.content.Context
import com.softbean.notifriend.*

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


        addAction(PendingService(context, PlayingService::class.java, "Play something else!").asAction())
        addAction(PendingService(context, IntroService::class.java, "Done Playing").asAction())
    }
}
