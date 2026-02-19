package com.example.bmicalculatorwithmvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.bmicalculatorwithmvvm.databinding.FragmentResultBinding
import com.example.bmicalculatorwithmvvm.viewmodels.BmiViewModel

class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding
    private lateinit var viewModel: BmiViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
//        home fragment data is not showing in result fragment that is why we need small change
        viewModel = ViewModelProvider(requireActivity()).get(BmiViewModel::class.java)
        binding = FragmentResultBinding.inflate(layoutInflater)
//        no need to get bundle data after view model implementation
//        val bmi = arguments?.getDouble("bmi")
//        val greet = arguments?.getString("greet") //if we dont pass same and same data type we will not get value using bundle
        val greet = ResultFragmentArgs.fromBundle(arguments).greet
//        bmiScoreTV.text = bmi.toString()

//        setting observer
        viewModel.bmi.observe(viewLifecycleOwner, { bmi ->
            binding.bmiResult.text =
                String.format("%.1f", bmi) // to show only 1 decimal after .
        })

//        setting observer
        viewModel.category.observe(viewLifecycleOwner, {category ->
            binding.categoryTV.text = category
        })

        return binding.root
    }
}
