package com.softbean.notifriend.eating

import android.content.Context
import com.softbean.notifriend.*

open class FoodNotification constructor(context: Context) : Notification(context) {
    init {
        title = "Nubb is eating"

    }
    fun addFoodActions(context: Context){
        addAction(PendingService(context, HungryService::class.java, "Different Snack!").asAction())
        addAction(PendingService(context, IntroService::class.java, "Done Eating").asAction())
    }

}