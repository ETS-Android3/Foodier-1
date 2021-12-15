// This file was created by Jade D'Souza, Lauren Ng, Shruti Kompella
// for our Food Item data.
package edu.uw.foodier

data class FoodItem(
    val food_name: String,
    val food_image: String,
    val restaurant: String,
    val address: String,
    var timeDistance: String = "0 min"
)
