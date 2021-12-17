package edu.uw.foodier.adapter
// This file is for the homePage created by Lauren Ng
// specifically for the card functionality and populating it with content
// creating navigation to pass the foodItem object to details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.uw.foodier.Constants
import edu.uw.foodier.FoodItem
import edu.uw.foodier.FoodItemType
import edu.uw.foodier.R
import edu.uw.foodier.viewmodels.homePageViewModel

class FoodListAdapter (private val mainViewModel: homePageViewModel): RecyclerView.Adapter<FoodListAdapter.ProfileViewHolder>() {
    private var foodList: List<FoodItem>? = null

    // when the viewHolder is created, we inflate the view and return with the view itself
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_item_card, parent, false)
        return ProfileViewHolder(view)
    }

    // getting the count size of the foodList
    override fun getItemCount() = foodList?.size ?: 0

    // updating the data with new data
    fun updateData(newList: List<FoodItem>) {
        foodList = newList
        this.notifyDataSetChanged()
    }

    // updating the object's distance calculation
    fun updateDistance(item: FoodItem) {
        foodList?.get(item.index)?.timeDistance = item.timeDistance
        this.notifyItemChanged(item.index)
    }

    // to display the data at the specified position and connecting the navigation to detail page
    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        foodList?.let {
            mainViewModel.getDistanceObject(it[position])
            val realObject = it[position] //homePageModel.getDistanceObject(it[position]) //
            holder.bind(realObject)

            // bundling up data to be passed to detail view
            val foodItemObj = FoodItemType()
            foodItemObj.itemName = it[position].food_name
            foodItemObj.foodImage = it[position].food_image
            foodItemObj.restaurant = it[position].restaurant
            foodItemObj.address = it[position].address
            val bundle = bundleOf(Constants.HOME_PAGE_TO_DETAIL_PAGE_BUNDLE to foodItemObj)

            // switching view to details page
            holder.itemView.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_home_to_details, bundle)
            )
        }
    }

    // connecting the data with the card view to display accordingly.
    class ProfileViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val image: ImageView = view.findViewById(R.id.foodImage)
        private val foodName: TextView = view.findViewById(R.id.foodHeader)
        private val restaurantName: TextView = view.findViewById(R.id.restaurant_name)
        private val distanceText: TextView = view.findViewById(R.id.distanceAway)

        fun bind(data: FoodItem) { // want to bind with song object probably
            foodName.text = data.food_name
            restaurantName.text = data.restaurant
            distanceText.text = data.timeDistance

            Glide.with(this.itemView).load(data.food_image).into(image)
            image.contentDescription = "${data.food_name} of the food item from ${data.restaurant}"
        }

    }


}