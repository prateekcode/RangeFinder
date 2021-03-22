package com.mefycare.rangefinder.utils

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mefycare.rangefinder.constant.Constants.Companion.TAG
import com.mefycare.rangefinder.model.TestItem
import java.lang.NullPointerException

object RangeObserver {

    fun getTheRange(context: Context, key: String, gender: String, age: String) : String{
        var range= ""
        val newJsonString = getJsonDataFromAsset(context, "json_tests.json")
        val gson = Gson()
        val listTestItem = object : TypeToken<List<TestItem>>() {}.type
        val item: List<TestItem> = gson.fromJson(newJsonString, listTestItem)
        item.forEachIndexed { idx, item ->
            for (element in item.children) {
                try {
                    element?.let {
                        Log.d(TAG, "Size of ranges of Children: ${it.ranges.size} ")
                        Log.d(TAG, "Key of Children: ${it.key} ")
                        if (it.key == key){
                            for (i in it.ranges.indices)
                                if (it.ranges[i].age == age && it.ranges[i].gender.equals(gender, ignoreCase = true)){
                                    Log.d(TAG, "Range for $age and $gender: ${it.ranges[i].range}")
                                    range = it.ranges[i].range.toString()
                                }
                        }

                    }
                } catch (n: NullPointerException) {
                    n.localizedMessage
                }
            }
        }
        return range
    }

    fun ageFromUserInput(age: Int, mdy: String): String{
        var stringAge = ""
        when (mdy) {
            "days" -> {
                stringAge = if (age < 30){
                    "0-30 days"
                }else{
                    "31-60 days"
                }
            }
            "months" -> {
                stringAge = when (age) {
                    in 2..3 -> {
                        "2-3 months"
                    }
                    in 6..12 -> {
                        "6-12 months"
                    }
                    else -> {
                        "Not Found"
                    }
                }
            }
            else -> {
                stringAge = when (age) {
                    in 1..5 -> {
                        "1-5 years"
                    }
                    in 5..11 -> {
                        "5-11 years"
                    }
                    in 12..18 -> {
                        "12-18 years"
                    }
                    else -> {
                        "18 years"
                    }
                }
            }
        }
        return stringAge
    }
}