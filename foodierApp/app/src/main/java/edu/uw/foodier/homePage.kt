package edu.uw.foodier

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import edu.uw.foodier.databinding.HomePageBinding

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

        val foodItemObj = FoodItemType()
        foodItemObj.itemName = "Japchae"
        foodItemObj.food_image = "https://s3-media0.fl.yelpcdn.com/bphoto/m6Xl1f5SL8ctmlHJYryHHg/o.jpg"
        foodItemObj.restaurant = "Korean Tofu House"
        foodItemObj.address = "4142 Brooklyn Ave NE Seattle, WA 98105"
        val bundle = bundleOf(Constants.HOME_PAGE_TO_DETAIL_PAGE_BUNDLE to foodItemObj)

        binding.homeButton.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_details, bundle)
        }
    }


}