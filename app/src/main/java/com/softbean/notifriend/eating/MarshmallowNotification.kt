package com.softbean.notifriend.eating

import android.content.Context
import com.softbean.notifriend.*

class MarshmallowNotification constructor(context: Context, drawableId: Int): Notification(context) {
    init {
        title = "Nubb is eating"
        text = "You gave him a marshmallow"
        subtext = "Nubb's space"
        largeIconId = R.drawable.smolnubb

        val bigStyle = BigPictureStyle(context)
        bigStyle.bigContentTitle = "A marshmallow?"
        bigStyle.summaryText = "Looks tasty..."
        bigStyle.bigPictureDrawableId = drawableId
        style = bigStyle

        addAction(PendingService(context, MarshmallowService::class.java, "Another").asAction())
        addAction(PendingService(context, HungryService::class.java, "Back").asAction())
        addAction(PendingService(context, IntroService::class.java, "Done Eating").asAction())
    }
}
