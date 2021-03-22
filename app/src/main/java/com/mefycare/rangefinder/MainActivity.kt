package com.mefycare.rangefinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mefycare.rangefinder.utils.RangeObserver
import com.mefycare.rangefinder.constant.Constants.Companion.TAG

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val d = "days"
        val m = "months"
        val y = "years"

        val ageOfPatient = RangeObserver.ageFromUserInput(50, y)
        RangeObserver.getTheRange(applicationContext, "hct_hematocrit", "Male", ageOfPatient)

        Log.d(TAG, RangeObserver.ageFromUserInput(50, "years"))
    }
}