package com.example.bmicalculatorwithmvvm.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.bmicalculatorwithmvvm.ResultFragment.Companion.normal
import com.example.bmicalculatorwithmvvm.ResultFragment.Companion.obisity1
import com.example.bmicalculatorwithmvvm.ResultFragment.Companion.obisity2
import com.example.bmicalculatorwithmvvm.ResultFragment.Companion.obisity3
import com.example.bmicalculatorwithmvvm.ResultFragment.Companion.overweight
import com.example.bmicalculatorwithmvvm.ResultFragment.Companion.underweitht

class BmiViewModel : ViewModel() {
    //    separator class only business logic
//    adding 2 class level variable so that we can access these in other class
    var bmi = 0.0
    var category = ""
    fun calculateBmi(weight: Double, height: Double) {
        bmi = weight / (height * height)
        category = when (String.format("%.1f", bmi).toDouble()) {
            in 0.0..18.4 -> underweitht
            in 18.5..24.9 -> normal
            in 25.0..29.9 -> overweight
            in 30.0..34.9 -> obisity1
            in 30.0..34.9 -> obisity2
            else -> obisity3
        }
        Log.e("BmiViewModel", "${String.format("%.1f", bmi).toDouble()}, $category")
    }

}