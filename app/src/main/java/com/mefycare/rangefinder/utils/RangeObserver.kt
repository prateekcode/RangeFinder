package com.mefycare.rangefinder.utils

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mefycare.rangefinder.constant.Constants.Companion.TAG
import com.mefycare.rangefinder.model.TestItem
import java.lang.NullPointerException

object RangeObserver {

    fun getTheRange(context: Context, key: String, gender: String, age: String){
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
                                if (it.ranges[i].age == age && it.ranges[i].gender == gender){
                                    Log.d(TAG, "Range for $age and $gender: ${it.ranges[i].range}")
                                }
                        }

                    }
                } catch (n: NullPointerException) {
                    n.localizedMessage
                }
            }
        }
    }
}