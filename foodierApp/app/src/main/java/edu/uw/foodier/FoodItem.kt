// This file was created by Jade D'Souza, Lauren Ng, Shruti Kompella
// for our Food Item data.
// Shruti implemented Room database components
package edu.uw.foodier
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Food Item class defines attributes for each food item object and all columns in
// bookmarked_food_items table in room database
@Entity(tableName = "bookmarked_food_items")
data class FoodItem(

    @PrimaryKey(autoGenerate = false)
    val food_name: String,

    @ColumnInfo(name = "foodImg")
    val food_image: String,

    @ColumnInfo(name = "restaurantName")
    val restaurant: String,

    @ColumnInfo(name = "addressName")
    val address: String,

    @ColumnInfo(name = "indexx")
    var index: Int,

    @ColumnInfo(name = "timeDist")
    var timeDistance: String = "0 min"
)
