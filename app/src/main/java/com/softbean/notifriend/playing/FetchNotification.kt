package com.softbean.notifriend.playing

import android.content.Context
import com.softbean.notifriend.*

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


        addAction(PendingService(context, PlayingService::class.java, "Back").asAction())
        addAction(PendingService(context, IntroService::class.java, "Home").asAction())

    }
}