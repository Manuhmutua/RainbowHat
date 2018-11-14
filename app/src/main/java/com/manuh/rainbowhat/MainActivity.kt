package com.manuh.rainbowhat

import android.app.Activity
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import com.google.android.things.contrib.driver.apa102.Apa102
import com.google.android.things.contrib.driver.bmx280.Bmx280SensorDriver
import com.google.android.things.contrib.driver.ht16k33.AlphanumericDisplay
import com.google.android.things.pio.Gpio
import com.google.android.things.pio.PeripheralManager
import java.io.IOException


class MainActivity : Activity() {

    private lateinit var mDisplay: AlphanumericDisplay
    private lateinit var mLedstrip: Apa102
    private lateinit var mEnvironmentalSensorDriver: Bmx280SensorDriver
    private lateinit var mSensorManager: SensorManager
    private val TAG = "HomeActivity"
    private val BUTTON_PIN_NAME = "GPIO6_IO14"
    private lateinit var mButtonGpio: Gpio


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(TAG, "Weather Station Started")

        val pioManager = PeripheralManager.getInstance()
        Log.d(TAG, "Available GPIO: " + pioManager.gpioList)

        try {
            val t1 = Thread(Threads("MANU"))
            val t2 = Thread(Threads("ERIC"))
            val t3 = Thread(Threads("DERO"))
            val t4 = Thread(Threads("MANU"))
                t1.start()
                t2.start()
                t3.start()
                t4.start()

        } catch (e: IOException) {
            throw RuntimeException("Error initializing display", e)
        }


//        try {
//            // Create GPIO connection.
//            mButtonGpio = pioManager.openGpio(BUTTON_PIN_NAME)
//
//            // Configure as an input, trigger events on every change.
//            mButtonGpio.setDirection(Gpio.DIRECTION_IN)
//            mButtonGpio.setEdgeTriggerType(Gpio.EDGE_BOTH)
//            // Value is true when the pin is LOW
//            mButtonGpio.setActiveType(Gpio.ACTIVE_LOW)
//        } catch (e: IOException) {
//            Log.w(TAG, "Error opening GPIO", e)
//        }
//
//        mSensorManager = getSystemService(SensorManager::class.java)
//
//        // Initialize temperature/pressure sensors
//        try {
//            mEnvironmentalSensorDriver = RainbowHat.createSensorDriver()
//            // Register the drivers with the framework
//            mEnvironmentalSensorDriver.registerTemperatureSensor()
//            mEnvironmentalSensorDriver.registerPressureSensor()
//            mEnvironmentalSensorDriver.registerHumiditySensor()
//
//            Log.d(TAG, "Initialized I2C BMP280")
//        } catch (e: IOException) {
//            throw RuntimeException("Error initializing BMP280", e)
//        }
//
//
//        // Initialize 14-segment display
//        try {
//            mDisplay = RainbowHat.openDisplay()
//            mDisplay.setEnabled(true)
//            //mDisplay.display("TEST")
//            Log.d(TAG, "Initialized I2C Display")
//        } catch (e: IOException) {
//            throw RuntimeException("Error initializing display", e)
//        }
//
//        var pattern1 = intArrayOf(
//            Color.BLUE,
//            Color.DKGRAY,
//            Color.GREEN,
//            Color.TRANSPARENT,
//            Color.GREEN,
//            Color.CYAN,
//            Color.LTGRAY
//        )
//        val pattern2 = intArrayOf(
//            Color.BLUE,
//            Color.GREEN,
//            Color.RED,
//            Color.GRAY,
//            Color.YELLOW,
//            Color.MAGENTA,
//            Color.CYAN
//        )
//
//        fun createRandPattern(red: Int, green: Int, blue: Int): IntArray {
//            var randPattern = intArrayOf(
//                Color.argb(6, red, green, blue),
//                Color.argb(6, red, green, blue),
//                Color.argb(7, red, green, blue),
//                Color.argb(6, red, green, blue),
//                Color.argb(5, red, green, blue),
//                Color.argb(5, red, green, blue),
//                Color.argb(5, red, green, blue)
//            )
//            return randPattern
//        }
//
//        var colorPatterns = arrayListOf(pattern1, pattern2)
//
//
//        var friendsNames = arrayOf("DERO", "ERIC", "MANU")
//        var friendsCount = 0
//
//        var foreverCount = 0
//
//        val t1 = Thread(Threads("MANU"))
//        val t2 = Thread(Threads("ERIC"))
//        val t3 = Thread(Threads("DERO"))
//        val t4 = Thread(Threads("MANU"))
//
////        fun ledPattern1() {
////            val random = Random()
////            var thread = object : Thread() {
////                override fun run() {
////                    try {
////                        while(true){
////                            if(ra 7)
////                            for (i in 1..7) {
////                                if (i == 7) {
////                                    pattern1 = intArrayOf(
////                                        Color.BLUE,
////                                        Color.TRANSPARENT,
////                                        Color.TRANSPARENT,
////                                        Color.TRANSPARENT,
////                                        Color.TRANSPARENT,
////                                        Color.TRANSPARENT,
////                                        Color.TRANSPARENT
////                                    )
////                                    mDisplay.display(friendsNames[friendsCount])
////                                    if(friendsCount == 2){
////                                        friendsCount = 0
////                                    }
////                                    friendsCount++
////                                } else {
////                                    pattern1[i] = pattern2[i]
////                                }
////                                mLedstrip.write(pattern1)
////                                Thread.sleep(100)
////                            }
////                            foreverCount ++
////                        }
////
////                    } catch (e: InterruptedException) {
////                        e.printStackTrace()
////                    } finally {
////                        // Transition to the new activity
////                    }
////                }
////            }
////            thread.start()
////
////        }
//
//
//        // Initialize LED strip
//        try {
//            mLedstrip = RainbowHat.openLedStrip()
//            val LEDSTRIP_BRIGHTNESS = 2
//            mLedstrip.brightness = LEDSTRIP_BRIGHTNESS
////            ledPattern1()
//            //ledPattern2()
//            Log.d(TAG, "Initialized SPI LED strip")
//        } catch (e: IOException) {
//            throw RuntimeException("Error initializing LED strip", e)
//        }

    }


    override fun onDestroy() {
        super.onDestroy()

        if (true) {
            try {
                mDisplay.clear()
                mDisplay.setEnabled(false)
                mDisplay.close()
            } catch (e: IOException) {
                Log.e(TAG, "Error closing display", e)
            } finally {
                mDisplay
            }
        }

        if (true) {
            try {
                mLedstrip.brightness = 0
                mLedstrip.write(IntArray(7))
                mLedstrip.close()
            } catch (e: IOException) {
                Log.e(TAG, "Error closing LED strip", e)
            } finally {
                mLedstrip
            }
        }
    }
}

