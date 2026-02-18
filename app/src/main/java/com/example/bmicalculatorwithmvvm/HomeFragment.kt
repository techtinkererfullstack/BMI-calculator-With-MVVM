package com.example.bmicalculatorwithmvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment


class HomeFragment : Fragment() {
    private lateinit var weightET: EditText
    private lateinit var heightET: EditText
    private lateinit var calculateBTN: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        weightET = view.findViewById(R.id.wightInputET)
        heightET = view.findViewById(R.id.heightInputET)
        calculateBTN = view.findViewById(R.id.calculateBTN)
        calculateBTN.setOnClickListener { v->
            val weight= weightET.text.toString().toDouble()
            val height= heightET.text.toString().toDouble()


        }

        return view
    }


}