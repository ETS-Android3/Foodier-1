package edu.uw.foodier

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import edu.uw.foodier.databinding.DetailPageBinding

class detailPage : Fragment() {
    private var _binding: DetailPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // get FoodItem Object from Main Page
        val value = arguments?.getParcelable<FoodItemType>(Constants.HOME_PAGE_TO_DETAIL_PAGE_BUNDLE)
        if (value != null) {
            Log.d("detailPage", value.itemName)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = DetailPageBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.detailButton.setOnClickListener {
            findNavController().navigate(R.id.action_details_to_bookmark)
        }
    }
}