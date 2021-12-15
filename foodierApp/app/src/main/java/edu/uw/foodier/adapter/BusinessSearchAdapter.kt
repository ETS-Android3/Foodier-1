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

class BusinessSearchAdapter(
    val businesses: List<Business>
) : RecyclerView.Adapter<BusinessSearchAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent)
    override fun getItemCount() = businesses.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(businesses[position])
    }

    class ViewHolder(
        parent: ViewGroup
    ) : RecyclerView.ViewHolder(parent.inflate(R.layout.business_search_result)) {
        val image: ImageView = itemView.findViewById(R.id.imageBus)
        val name: TextView = itemView.findViewById(R.id.name)

        fun bind(business: Business) {
            name.text = business.name
            Glide.with(image.context).load(business.imageUrl).into(image)
        }
    }
}

private fun ViewGroup.inflate(@LayoutRes layout: Int): View {
    return LayoutInflater.from(context).inflate(layout, this, false)
}
