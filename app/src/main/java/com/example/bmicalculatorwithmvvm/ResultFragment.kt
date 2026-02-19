package com.example.bmicalculatorwithmvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ResultFragment : Fragment() {
    private lateinit var bmiScoreTV: TextView
    private lateinit var categoryTV: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_result, container, false)
        bmiScoreTV = view.findViewById(R.id.bmiResult)
        categoryTV = view.findViewById(R.id.categoryTV)
        val bmi = arguments?.getDouble("bmi")
//        bmiScoreTV.text = bmi.toString()
        bmiScoreTV.text = String.format("%.1f", bmi) // to show only 1 decimal after .

        val category = when (String.format("%.1f", bmi).toDouble()) {
            in 0.0..18.4 -> underweitht
            in 18.5..24.9 -> normal
            in 25.0..29.9 -> overweight
            in 30.0..34.9 -> obisity1
            in 30.0..34.9 -> obisity2
            else -> obisity3
        }

        categoryTV.text = category

        return view

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
