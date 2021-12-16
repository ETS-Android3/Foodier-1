// This file was created by Jade D'Souza for the Detail Page
// and utilizes the Yelp API to find similar restaurants for the
// given food item, in Washington specifically.
package edu.uw.foodier

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.uw.foodier.adapter.BusinessSearchAdapter
import edu.uw.foodier.model.BusinessRepo
import kotlinx.android.synthetic.main.detail_page.view.*

class detailPage : Fragment() {
    private lateinit var selectedFood: FoodItemType
    private var businessRepo: BusinessRepo = BusinessRepo.instance()

    // on create allows our fragment to be navigated to
    // after clicking the card. Additionally, we are
    // storing the food item object passed to the class in a global variable
    // Global variable will be used to display further details. Item name
    // reference from the FoodItem is used as a query term for our API search
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

    // creates our view - displays restaurant name, address,
    // image of restaurant through Glide, searches API with food item name,
    // populates recycler view with results from API, and allows navigation
    // into bookmark page
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.detail_page, container, false)
        val img: ImageView = rootView.findViewById<ImageView>(R.id.img)
        val title: TextView = rootView.findViewById(R.id.detailTitle)
        val address : TextView = rootView.findViewById(R.id.address)
        val restaurant : TextView = rootView.findViewById(R.id.restaurant_name)
        val pointView : TextView = rootView.findViewById(R.id.hiWorld);

        title.text = selectedFood.itemName
        address.text = selectedFood.address
        restaurant.text = selectedFood.restaurant
        Glide.with(this).load(selectedFood.foodImage).into(img)

        val recycler = rootView.findViewById<RecyclerView>(R.id.listView)
        recycler.layoutManager = LinearLayoutManager(activity)

       businessRepo.search(selectedFood.itemName).subscribe { list, _ ->
                val hasNoResults = (list?.total ?: 0) == 0
                recycler.isGone = hasNoResults
                if (hasNoResults) {
                    pointView.text = getString(R.string.empty_result, selectedFood.itemName)
                }
                else {
                    pointView.setText("Other Restaurants that serve " + selectedFood.itemName)
                    recycler.adapter = BusinessSearchAdapter(list.businesses)
                }
        }

        rootView.detailButton.setOnClickListener {
            findNavController().navigate(R.id.action_details_to_bookmark)
        }
        return rootView
    }

}