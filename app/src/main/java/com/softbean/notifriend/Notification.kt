package com.softbean.notifriend

import android.content.Context
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

open class Notification constructor(private val context: Context) {
    private val builder: NotificationCompat.Builder
    var title: String? = null
    var text: String? = null
    var subtext: String? = null
    var style: NotificationStyle? = null
    var largeIconId: Int = 0

    companion object {
        val channelId = "NOTIFRIEND_CHANNEL_ID"
        val notificationId = 176
        val color = 6405212
    }
    init {
        builder = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.drawable.ic_small_nubb)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setColor(color)
    }

    fun addAction(action: NotificationCompat.Action) {
        builder.addAction(action)
    }

    fun send() {
        builder.setContentTitle(title)
        builder.setContentText(text)
        builder.setSubText(subtext)
        builder.setStyle(style?.getStyle())
        builder.setLargeIcon((BitmapFactory.decodeResource(context.resources, largeIconId)))

        with(NotificationManagerCompat.from(context)) {
            // notificationId is a unique int for each notification that you must define
            notify(notificationId, builder.build())
        }
    }
}