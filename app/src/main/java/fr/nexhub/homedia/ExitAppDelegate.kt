package fr.nexhub.homedia

import android.window.OnBackInvokedDispatcher
import androidx.activity.ComponentActivity
import androidx.activity.addCallback
import androidx.core.os.BuildCompat

fun ComponentActivity.registerOnBackPress(onBackPress: () -> Unit) {
    if (BuildCompat.isAtLeastT()) {
        onBackInvokedDispatcher.registerOnBackInvokedCallback(
            OnBackInvokedDispatcher.PRIORITY_DEFAULT,
        ) {
            // Back is pressed... Finishing the activity
            onBackPress()
        }
    } else {
        onBackPressedDispatcher.addCallback(this /* lifecycle owner */) {
            // Back is pressed... Finishing the activity
            onBackPress()
        }
    }
}
