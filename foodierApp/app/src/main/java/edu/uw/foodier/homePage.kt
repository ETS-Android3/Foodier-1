package edu.uw.foodier

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import edu.uw.foodier.databinding.HomePageBinding
import edu.uw.foodier.databinding.HomePageBindingImpl

class homePage : Fragment() {
    private var _binding: HomePageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = HomePageBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.homeButton.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_details)
        }
    }


}