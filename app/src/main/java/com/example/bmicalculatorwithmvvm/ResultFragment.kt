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
//        bmiScoreTV.text = bmi.toString()
        binding.bmiResult.text =
            String.format("%.1f", viewModel.bmi) // to show only 1 decimal after .
        binding.categoryTV.text = viewModel.category
        return binding.root
    }
}
