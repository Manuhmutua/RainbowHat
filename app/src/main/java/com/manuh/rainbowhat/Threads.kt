package com.manuh.rainbowhat

import android.content.ContentValues.TAG
import android.util.Log
import com.google.android.things.contrib.driver.ht16k33.AlphanumericDisplay
import com.google.android.things.contrib.driver.rainbowhat.RainbowHat
import java.io.IOException
import java.util.*

class Threads(x: String?) : Runnable {

    private lateinit var mDisplay: AlphanumericDisplay
    var name: String? = x
    var time_: Long = 1000
    var r = Random()

    override fun run() {
        try {
            try {
                mDisplay = RainbowHat.openDisplay()
                mDisplay.setEnabled(true)
                mDisplay.display(name)
                Log.d(TAG, "Initialized I2C Display")
            } catch (e: IOException) {
                throw RuntimeException("Error initializing display", e)
            }
            Thread.sleep(time_)

        } catch (e: Exception) {
            throw RuntimeException("Error initializing display", e)
        }

    }
}