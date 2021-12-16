
// Created by Shruti Kompella
package edu.uw.foodier

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Adapter class for bookmarks
class BookmarkAdapter(private val dataSet: MutableList<FoodItem>) :
    RecyclerView.Adapter<BookmarkAdapter.ViewHolder>() {

        var itemClickListener: ((foodName: String) -> Unit)? = null

        /**
         * Provide a reference to the textview inside each row of the bookmark activity recyclerview
         */
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val textViewFoodName = view.findViewById(R.id.foodNameInRow) as TextView
        }

        // Create new view (inflating) for each row of recycler view in bookmark page
        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            // Create a new view, which defines the UI of the list item
            val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.recycler_view_row, viewGroup, false)

            return ViewHolder(view)
        }

        // Replace the contents of recycler view row (invoked by the layout manager) in Bookmark page
        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
            // Getting element from names list at this position
            val element = dataSet[position]
            // Updating the text of the txtName with this element
            viewHolder.textViewFoodName.text = element.food_name

            // Adding an OnClickLister to the holder.itemView
            viewHolder.itemView.setOnClickListener {
                // Invoking itemClickListener and passing it the position and name
                // invoke details fragment
                itemClickListener?.invoke(element.food_name)
            }
        }

        // Return the size of dataset (foods in room database)
        override fun getItemCount(): Int {
            return dataSet.size
        }
    }