package com.mefycare.rangefinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mefycare.rangefinder.utils.RangeObserver

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RangeObserver.getTheRange(applicationContext, "hgb_haemoglobin", "male", "0-30 days")
    }
}