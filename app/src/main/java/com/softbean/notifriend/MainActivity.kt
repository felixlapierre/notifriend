package com.softbean.notifriend

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.softbean.notifriend.eating.HungryService
import com.softbean.notifriend.playing.PlayingService

class MainActivity : AppCompatActivity() {
    private val channelId = "NOTIFRIEND_CHANNEL_ID"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createNotificationChannel()
        createRepeatingNotifications()
    }

    private fun createNotificationChannel() {
        //API 26+ needs a Notification Channel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_LOW
            val channel = NotificationChannel(channelId, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    fun onActivate(view: View) {

        view.isActivated = true
        this.findViewById<TextView>(R.id.buttonText).text = "Nubb is waiting!"
        this.findViewById<TextView>(R.id.buttonText).textSize = 35F
        createRepeatingNotifications()
        IntroNotification(this).send()
    }

    private fun createRepeatingNotifications() {
        createHungry().repeatDailyAt(8)
        createHungry().repeatDailyAt(12)
        createHungry().repeatDailyAt(18)
        createSleepy().repeatDailyAt(23)

        createPlay().delay(10 * 60 * 1000)
    }

    private fun createHungry(): PendingService {
        return PendingService(this, HungryService::class.java, "Hungry")
    }

    private fun createSleepy(): PendingService {
        return PendingService(this, SnoozeService::class.java, "Snooze")
    }

    private fun createPlay(): PendingService {
        return PendingService(this, PlayingService::class.java, "Play")
    }
}
