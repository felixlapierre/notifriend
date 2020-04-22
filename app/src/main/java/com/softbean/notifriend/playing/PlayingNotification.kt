package com.softbean.notifriend.playing

import android.content.Context
import com.softbean.notifriend.*

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

        addAction(PendingService(context, FetchService::class.java, "Fetch").asAction())
        addAction(PendingService(context, PatService::class.java, "Pats").asAction())
        addAction(PendingService(context, IntroService::class.java, "Home").asAction())
        addAction(PendingService(context, SnoozeService::class.java, "Snooze").asAction())
    }
}