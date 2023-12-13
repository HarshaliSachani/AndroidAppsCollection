package com.map.androidappcollections.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent

/**
 * Created by Harshali.Sachani on 12/13/2023.
 */

inline fun <reified T : Activity> Context.startActivity(block: Intent.() -> Unit = {}) {
    startActivity(Intent(this, T::class.java).apply(block))
}