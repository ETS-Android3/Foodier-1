// This file was created by Jade D'Souza for the Detail Page
// to call the Yelp API to find similar restaurants for the
// given food item, in Washington specifically.
// We used open source code by Yelp in order to navigate their API.
package edu.uw.foodier.model
import com.squareup.moshi.Json

// Data class to store name of restaurant and its image url
data class Business(val name: String, @Json(name = "image_url") val imageUrl: String)