package com.example.bmicalculatorwithmvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.bmicalculatorwithmvvm.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)



        binding.calculateBTN.setOnClickListener { v->
            val weight= binding.wightInputET.text.toString().toDouble()
            val height= binding.heightInputET.text.toString().toDouble()

            val bmi = weight/(height*height)
            //Toast.makeText(activity, bmi.toString(), Toast.LENGTH_SHORT).show()
            val bundle = bundleOf("bmi" to bmi)
            findNavController().navigate(R.id.resultAction, bundle)
        }

        return binding.root
    }


}