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
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.bmicalculatorwithmvvm.databinding.FragmentHomeBinding
import com.example.bmicalculatorwithmvvm.viewmodels.BmiViewModel


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: BmiViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
//        initializing view binding
        binding = FragmentHomeBinding.inflate(layoutInflater)
//        initializing view model, here this is Home fragment
        //        home fragment data is not showing in result fragment that is why we need small change
        viewModel = ViewModelProvider(requireActivity()).get(BmiViewModel::class.java)


        binding.calculateBTN.setOnClickListener { v->
            val weight= binding.wightInputET.text.toString().toDouble()
            val height= binding.heightInputET.text.toString().toDouble()
            viewModel.calculateBmi(weight, height)

            //Toast.makeText(activity, bmi.toString(), Toast.LENGTH_SHORT).show()
//            bundle is not needed after implementing view model because bmi is now in view model class
//            val bundle = bundleOf("bmi" to bmi)
            findNavController().navigate(R.id.resultAction)
        }

        return binding.root
    }


}