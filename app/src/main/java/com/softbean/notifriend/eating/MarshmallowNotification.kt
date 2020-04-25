package com.softbean.notifriend.eating

import android.content.Context
import com.softbean.notifriend.*

class MarshmallowNotification constructor(context: Context, drawableId: Int): FoodNotification(context) {
    init {
          text = "You gave him a marshmallow"

        val bigStyle = BigPictureStyle(context)
        bigStyle.bigContentTitle = "A marshmallow?"
        bigStyle.summaryText = "Looks tasty..."
        bigStyle.bigPictureDrawableId = drawableId
        style = bigStyle

        addAction(PendingService(context, MarshmallowService::class.java, "Another").asAction())
        this.addFoodActions(context)
    }
}
