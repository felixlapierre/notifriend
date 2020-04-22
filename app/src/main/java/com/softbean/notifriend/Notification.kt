package com.softbean.notifriend

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

open class Notification constructor(private val context: Context) {
    protected val builder: NotificationCompat.Builder
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
            .setOnlyAlertOnce(true)
            .setColor(color)
            .setDeleteIntent(createOnDismissedIntent())
            .setOngoing(true)
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

    /**
     * Sends the notification only if the passed service is the service that is currently active
     */
    fun send(serviceName: String) {
        if(NotifriendService.currentService == serviceName)
            send()
    }

    private fun createOnDismissedIntent(): PendingIntent {
        val intent = Intent(context, NotificationDismissedReceiver::class.java)
        intent.putExtra("com.softbean.notifriend.notificationId", notificationId)
        return PendingIntent.getBroadcast(context.applicationContext, notificationId, intent, 0)
    }

}