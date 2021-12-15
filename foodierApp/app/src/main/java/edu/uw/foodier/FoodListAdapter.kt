package edu.uw.foodier
// This file is for the homePage created by Lauren Ng

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.uw.foodier.databinding.FoodItemCardBinding
import edu.uw.foodier.viewmodels.homePageViewModel

class FoodListAdapter : RecyclerView.Adapter<FoodListAdapter.ProfileViewHolder>() {

    // put this data into the view model
    private var foodList: List<FoodItem>? = null
    private val homePageModel : homePageViewModel = homePageViewModel()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_item_card, parent, false)
        return ProfileViewHolder(view)
    }

    override fun getItemCount() = foodList?.size ?: 0

    fun updateData(newList: List<FoodItem>) {
        foodList = newList

        this.notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        foodList?.let {
            val realObject = homePageModel.getDistanceObject(it[position]) //it[position]
            holder.bind(realObject)

            // bundling up data to be passed to detail view
            val foodItemObj = FoodItemType()
            foodItemObj.itemName = it[position].food_name
            foodItemObj.food_image = it[position].food_image
            foodItemObj.restaurant = it[position].restaurant
            foodItemObj.address = it[position].address
            val bundle = bundleOf(Constants.HOME_PAGE_TO_DETAIL_PAGE_BUNDLE to foodItemObj)

            // switching view to details page
            holder.itemView.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_home_to_details, bundle)
            )
        }
    }

    class ProfileViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val image: ImageView = view.findViewById(R.id.foodImage)
        private val foodName: TextView = view.findViewById(R.id.foodHeader)
        private val restaurantName: TextView = view.findViewById(R.id.restaurant_name)
        private val distanceText: TextView = view.findViewById(R.id.distanceAway)

        fun bind(data: FoodItem) { // want to bind with song object probably
            Log.d("BINDER FOOD ADAPTER", "this is distance: ${data.timeDistance}")
            foodName.text = data.food_name
            restaurantName.text = data.restaurant
            distanceText.text = data.timeDistance

            if (data.food_image != null) {
                Log.d("foodListAdapter", data.food_image)
                Glide.with(this.itemView).load(data.food_image).into(image)
                image.contentDescription = "${data.food_name} of the food item from ${data.restaurant}"
            }
        }

    }


}