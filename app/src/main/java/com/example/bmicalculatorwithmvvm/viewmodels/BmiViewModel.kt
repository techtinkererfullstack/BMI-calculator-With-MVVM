package com.example.bmicalculatorwithmvvm.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class BmiViewModel : ViewModel() {
    //    separator class only business logic
//    adding 2 class level variable so that we can access these in other class
    var bmi: MutableLiveData<Double> = MutableLiveData()
    var category: MutableLiveData<String> = MutableLiveData()

    fun calculateBmi(weight: Double, height: Double) {
        bmi.value = weight / (height * height)
        category.value = when (String.format("%.1f", bmi.value).toDouble()) {
            in 0.0..18.4 -> underweitht
            in 18.5..24.9 -> normal
            in 25.0..29.9 -> overweight
            in 30.0..34.9 -> obisity1
            in 30.0..34.9 -> obisity2
            else -> obisity3
        }
        Log.e("BmiViewModel", "${String.format("%.1f", bmi).toDouble()}, $category")


    }
    companion object {
        val underweitht = "UNDER WEIGHT"
        val normal = "NORMAL"
        val overweight = "OVER WEIGHT"
        val obisity1 = "OBISITY CLASS 1"
        val obisity2 = "OBISITY CLASS 2"
        val obisity3 = "OBISITY CLASS 3"
    }


}