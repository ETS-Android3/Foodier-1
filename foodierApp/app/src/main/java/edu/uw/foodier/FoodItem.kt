// This file was created by Jade D'Souza, Lauren Ng, Shruti Kompella
// for our Food Item data.
package edu.uw.foodier
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookmarked_food_items")
data class FoodItem(
//    @PrimaryKey(autoGenerate = false)
//    var nightId: Int ?= null,

//    @ColumnInfo(name = "foodName")
    @PrimaryKey(autoGenerate = false)
    val food_name: String,

    @ColumnInfo(name = "foodImg")
    val food_image: String,

    @ColumnInfo(name = "restaurantName")
    val restaurant: String,

    @ColumnInfo(name = "addressName")
    val address: String,

    @ColumnInfo(name = "timeDist")
    var timeDistance: String = "0 minutes"
)
