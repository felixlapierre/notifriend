package com.softbean.notifriend

import android.content.Context

class SnoozeNotification constructor(context: Context, drawableId: Int): Notification(context) {
    init {
        builder.setOngoing(false)
        title = "Nubb is taking a nap."
        text = "He'll be back later"
        largeIconId = R.drawable.smolnubb

        val bigStyle = BigPictureStyle(context)
        bigStyle.bigContentTitle = "Zzzzzzzzzzzzzzzzzzzz"
        bigStyle.bigPictureDrawableId = drawableId
        style = bigStyle

        addAction(PendingService(context, IntroService::class.java, "Wake up").asAction())
    }
}
