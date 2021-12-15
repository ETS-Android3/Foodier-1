// This file was created by Jade D'Souza for the Detail Page
// to call the Yelp API to find similar restaurants for the
// given food item, in Washington specifically.
// This is our adapter for the list of businesses for our
// recycler view.
// We used open source code by Yelp in order to navigate their API.
package edu.uw.foodier.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.uw.foodier.R
import edu.uw.foodier.model.Business

// adapter to be used for Business Models
class BusinessSearchAdapter(
    val businesses: List<Business>
) : RecyclerView.Adapter<BusinessSearchAdapter.ViewHolder>() {
    //overriding the create view holder method and storing the viewgroup passed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent)

    //overriding and storing the length of businesses
    override fun getItemCount() = businesses.size

    //binding our view for each item in our recycler view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(businesses[position])
    }

    // View Holder class for Restaurant and Image
    class ViewHolder(
        parent: ViewGroup
    ) : RecyclerView.ViewHolder(parent.inflate(R.layout.business_search_result)) {
        val image: ImageView = itemView.findViewById(R.id.imageBus)
        val name: TextView = itemView.findViewById(R.id.name)

        // binding business text to the view for the restaurant name
        // using glide to bind image url for the image view
        fun bind(business: Business) {
            name.text = business.name
            Glide.with(image.context).load(business.imageUrl).into(image)
        }
    }
}

// inflating to view on UI
private fun ViewGroup.inflate(@LayoutRes layout: Int): View {
    return LayoutInflater.from(context).inflate(layout, this, false)
}
