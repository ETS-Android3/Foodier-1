package edu.uw.foodier

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.yuyakaido.android.cardstackview.CardStackListener
import com.yuyakaido.android.cardstackview.Direction
import edu.uw.foodier.databinding.FoodItemCardBinding

class ProfileAdapter : RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {

    // put this data into the view model
    private var profiles: List<Profile>? = listOf(Profile(14,20,1,"Lauren", "https://st.depositphotos.com/2869437/3739/i/950/depositphotos_37392643-stock-photo-close-up-of-pug.jpg"),
        Profile(20,10,2,"Kristen", "https://st.depositphotos.com/2869437/3739/i/950/depositphotos_37392643-stock-photo-close-up-of-pug.jpg"),
        Profile(21,50,3,"Corey", "https://st.depositphotos.com/2869437/3739/i/950/depositphotos_37392643-stock-photo-close-up-of-pug.jpg"),
        Profile(24,60,4,"Bob", "https://st.depositphotos.com/2869437/3739/i/950/depositphotos_37392643-stock-photo-close-up-of-pug.jpg"))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ProfileViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.food_item_card,
            parent,
            false
        )
    )

    override fun getItemCount() = profiles?.size ?: 0

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        profiles?.let {
            holder.binding.profile = it[position]
            holder.binding.executePendingBindings()
        }
    }

    inner class ProfileViewHolder(val binding: FoodItemCardBinding) :
        RecyclerView.ViewHolder(binding.root)

}