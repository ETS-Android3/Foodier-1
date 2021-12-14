package edu.uw.foodier

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.roundToInt

/*
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.towm1204.votedataprovider.StateResult
import kotlin.math.roundToInt
import kotlinx.android.synthetic.main.recycler_view_row.*
 */

class BookmarkAdapter(private val dataSet: MutableList<Int>) :
    RecyclerView.Adapter<BookmarkAdapter.ViewHolder>() {

        var itemClickListener: ((blueVoteNum: String, redVoteNum: String) -> Unit)? = null

        /**
         * Provide a reference to the type of views that you are using
         * (custom ViewHolder).
         */
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val textViewFoodName = view.findViewById(R.id.foodNameInRow) as TextView
        }

        // Create new views (invoked by the layout manager)
        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            // Create a new view, which defines the UI of the list item
            val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.recycler_view_row, viewGroup, false)

            return ViewHolder(view)
        }

        // Replace the contents of a view (invoked by the layout manager)
        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
            // Getting element from names list at this position
            val element = dataSet[position]
            // Updating the text of the txtName with this element
            viewHolder.textViewFoodName.text = element.toString()

            // Adding an OnClickLister to the holder.itemView
            viewHolder.itemView.setOnClickListener {
                // Invoking itemClickListener and passing it the position and name
                itemClickListener?.invoke("stuff", "other stuff")
            }
        }

        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount(): Int {
            return dataSet.size
        }
    }