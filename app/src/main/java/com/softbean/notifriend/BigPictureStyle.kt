package com.softbean.notifriend

import android.content.Context
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat

class BigPictureStyle constructor(private val context: Context) : NotificationStyle {
    var bigPictureDrawableId: Int = 0
    var bigContentTitle: String? = null
    var summaryText: String? = null

    override fun getStyle(): NotificationCompat.Style {
        return NotificationCompat.BigPictureStyle()
            .bigPicture(BitmapFactory.decodeResource(context.resources, bigPictureDrawableId))
            .bigLargeIcon(null)
            .setBigContentTitle(bigContentTitle)
            .setSummaryText(summaryText)
    }
}