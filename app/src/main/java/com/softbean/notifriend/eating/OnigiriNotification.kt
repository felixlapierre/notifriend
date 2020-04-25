package com.softbean.notifriend.eating

import android.content.Context
import com.softbean.notifriend.*

class OnigiriNotification constructor(context: Context, drawableId: Int) : FoodNotification(context) {
    init {
        text = "You gave him onigiri"
        largeIconId = R.drawable.smolnubb

        val bigStyle = BigPictureStyle(context)
        bigStyle.bigContentTitle = "Onigiri!?"
        bigStyle.summaryText = "I love it!!"
        bigStyle.bigPictureDrawableId = drawableId
        style = bigStyle

        addAction(PendingService(context, OnigiriService::class.java, "Another").asAction())
        this.addFoodActions(context)
    }
}