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
        public val ACTION_PAT = "com.softbean.notifriend.action.pat"
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


        val snoozeIntent = Intent(this, SnoozeService::class.java)
        snoozeIntent.action = SnoozeService.SnoozeServiceProperties().TAG
        var snoozePendingIntent = PendingIntent.getActivity(this, 0, snoozeIntent, PendingIntent.FLAG_ONE_SHOT)
        val snoozeAction = NotificationCompat.Action.Builder(
            R.drawable.ic_small_nubb,
            "Naptime",
            snoozePendingIntent)
            .build()


        val builder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.ic_small_nubb)
            .setStyle(NotificationCompat.BigPictureStyle()
                .bigPicture(BitmapFactory.decodeResource(resources, R.drawable.samplenubb))
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
            .addAction(patAction).addAction(snoozeAction)

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
                    .bigPicture(BitmapFactory.decodeResource(resources, R.drawable.nubbounce))
                    .bigLargeIcon(null)
                    .setBigContentTitle("I love pats!")
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