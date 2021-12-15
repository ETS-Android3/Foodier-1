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

// EVERYONE FINISH UR SLIDE

// JADE
// fix landscape view - details - jade

// LAUREN
// Needs to update gps on front end - Lauren
// Clean up code - Lauren
// Persisting the card after looking at the detail - lauren (last priority)
// fix landscape view - main - lauren

// SHRUTI
// recycler view - shruti does it herself
// room db has data added to it - Shruti does it in Laurens file

/*
Clean code
No commented out code
Variable names should be understandable
Each method should be documented
Each class should be documented
Code should be well formatted
 */