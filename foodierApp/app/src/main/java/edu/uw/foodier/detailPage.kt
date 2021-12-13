package edu.uw.foodier

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import edu.uw.foodier.databinding.DetailPageBinding
import kotlinx.android.synthetic.main.detail_page.view.*

class detailPage : Fragment() {
   // private var _binding: DetailPageBinding? = null
   // private val binding get() = _binding!!
    private lateinit var selectedFood: FoodItemType

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // get FoodItem Object from Main Page
        val value = arguments?.getParcelable<FoodItemType>(Constants.HOME_PAGE_TO_DETAIL_PAGE_BUNDLE)
        if (value != null) {
            selectedFood = value
        }
        if (value != null) {
            Log.d("detailPage", value.itemName)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.detail_page, container, false)
        val img: ImageView = rootView.findViewById<ImageView>(R.id.img)
        val title: TextView = rootView.findViewById(R.id.detailTitle)
        val address : TextView = rootView.findViewById(R.id.address)
        val restaurant : TextView = rootView.findViewById(R.id.restaurant_name)

        title.text = selectedFood.itemName
        address.text = selectedFood.address
        restaurant.text = selectedFood.restaurant
        Glide.with(this).load(selectedFood.food_image).into(img)

        rootView.detailButton.setOnClickListener {
            findNavController().navigate(R.id.action_details_to_bookmark)
        }

        return rootView
    }

}