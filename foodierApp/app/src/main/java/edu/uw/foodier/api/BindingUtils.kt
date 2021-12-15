// This file was created by Jade D'Souza for the Detail Page
// to call the Yelp API to find similar restaurants for the
// given food item, in Washington specifically.
// We used open source code by Yelp in order to navigate their API.
package edu.uw.foodier

import androidx.databinding.BindingAdapter
import com.facebook.drawee.view.SimpleDraweeView

@BindingAdapter("image")
fun loadImage(view: SimpleDraweeView, url: String) {
    view.setImageURI(url)
}

// US
// making sure the UI looks normal.

// JADE
// fix landscape view - details - jade
// make sure text view shows up for sim restos - i can work on this myself

// LAUREN
// GPS - Lauren
// Clean up code - Lauren
// Persisting the card after looking at the detail - lauren
// fix landscape view - main - lauren

// SHRUTI
// recycler view - shruti does it herself
// room db has data added to it