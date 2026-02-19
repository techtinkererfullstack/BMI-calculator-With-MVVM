package com.example.bmicalculatorwithmvvm.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel


class BmiViewModel : ViewModel() {
    //    separator class only business logic
//    adding 2 class level variable so that we can access these in other class
    var bmi = 0.0
    var category = ""
    fun calculateBmi(weight: Double, height: Double) {
        bmi = weight / (height * height)
        category = when (String.format("%.1f", bmi).toDouble()) {
            in 0.0..18.4 -> BmiViewModel.underweitht
            in 18.5..24.9 -> BmiViewModel.normal
            in 25.0..29.9 -> BmiViewModel.overweight
            in 30.0..34.9 -> BmiViewModel.obisity1
            in 30.0..34.9 -> BmiViewModel.obisity2
            else -> BmiViewModel.obisity3
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