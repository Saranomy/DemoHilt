package com.saranomy.demohilt.presentations

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.saranomy.demohilt.R
import com.saranomy.demohilt.models.WaterBalloon
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    // do field injection
    @Inject
    lateinit var waterBalloon: WaterBalloon

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // waterBalloon exists in run-time, and ready to be popped
        val resultString = waterBalloon.pop()

        findViewById<TextView>(R.id.result).text = resultString
        Log.wtf(TAG, resultString)
    }
}