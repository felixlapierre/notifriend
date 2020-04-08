package com.softbean.notifriend

import android.app.IntentService
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {
    private val channelId = "NOTIFRIEND_CHANNEL_ID"
    private val notificationId = 176

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        //API 26+ needs a Notification Channel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }

    }


    fun onActivate(view: View) {

        val patIntent = Intent(this, PatService::class.java);
        patIntent.action = PatService.PatServiceProperties().TAG
        var patPendingIntent = PendingIntent.getService(this, 0, patIntent, PendingIntent.FLAG_ONE_SHOT)
        val patAction = NotificationCompat.Action.Builder(
            R.drawable.ic_small_nubb,
            "Pat Nubb",
            patPendingIntent)
            .build()


//        val snoozeIntent = Intent(this, SnoozeService::class.java)
//        var snoozePendingIntent = PendingIntent.getActivity(this, 0, snoozeIntent, PendingIntent.FLAG_ONE_SHOT)
//        val snoozeAction = NotificationCompat.Action.Builder(
//            R.drawable.ic_small_nubb,
//            "Naptime",
//            snoozePendingIntent)
//            .build()


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
            //.addAction(snoozeAction)

        with(NotificationManagerCompat.from(this)) {
            // notificationId is a unique int for each notification that you must define
            notify(notificationId, builder.build())
        }
    }


    private fun createNubbNotification(){

    }
}
