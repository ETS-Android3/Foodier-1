package edu.uw.foodier.model
import com.squareup.moshi.Json

data class Business(val name: String, @Json(name = "image_url") val imageUrl: String)