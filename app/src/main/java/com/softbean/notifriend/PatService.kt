package com.softbean.notifriend

import android.app.IntentService
import android.app.Notification
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import java.util.*
import kotlin.concurrent.schedule

class PatService() : IntentService("PatService") {

    class PatServiceProperties{
        public val TAG = "PatService"
    }

    private val channelId = "NOTIFRIEND_CHANNEL_ID"
    private val notificationId = 176
    private val properties = PatServiceProperties();


    override fun onHandleIntent(intent: Intent?) {
        Log.d(properties.TAG, " onHandleIntent()$intent")

        if (intent!= null){
            //if (properties.ACTION_PAT == intent.action)
            handleActionPat()
        }
    }

    private fun handleActionPat() {
        Log.d(properties.TAG, "handlePat()")

        val notificationManagerCompat = NotificationManagerCompat.from(applicationContext)
        notificationManagerCompat.notify(176, makePatNotification())

        Timer("Patting", false).schedule(2500) {
            deployBaseNotification()
        }
    }

    private fun deployBaseNotification(){
        val patIntent = Intent(this, PatService::class.java);
        patIntent.action = PatService.PatServiceProperties().TAG
        var patPendingIntent = PendingIntent.getService(this, 0, patIntent, PendingIntent.FLAG_ONE_SHOT)
        val patAction = NotificationCompat.Action.Builder(
            R.drawable.ic_small_nubb,
            "Pat Nubb",
            patPendingIntent)
            .build()


        val builder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.ic_small_nubb)
            .setStyle(NotificationCompat.BigPictureStyle()
                .bigPicture(BitmapFactory.decodeResource(resources, R.drawable.nr480))
                .bigLargeIcon(null)
                .setBigContentTitle("Hi!")
                .setSummaryText("I love you!")
            )
            .setContentTitle("Your lad wants to talk to you!")
            .setContentText("He thinks you're doing great!")
            .setSubText("Nubb's space")
            .setLargeIcon((BitmapFactory.decodeResource(resources, R.drawable.smolnubb)))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setColor(6405212)
            .addAction(patAction)

        with(NotificationManagerCompat.from(this)) {
            // notificationId is a unique int for each notification that you must define
            notify(notificationId, builder.build())
        }

    }

    private fun makePatNotification(): Notification{

        val builder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.ic_small_nubb)
            .setStyle(
                NotificationCompat.BigPictureStyle()
                    .bigPicture(BitmapFactory.decodeResource(resources, R.drawable.nrbedtime))
                    .bigLargeIcon(null)
                    .setBigContentTitle("I love pats!").setSummaryText(" ")
                    .setSummaryText(null)
            )
            .setContentTitle("You pat nubb!")
            .setContentText("UwU")
            .setSubText("Nubb's space")
            .setLargeIcon((BitmapFactory.decodeResource(resources, R.drawable.smolnubb)))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setColor(6405212)

        return builder.build()
    }


}