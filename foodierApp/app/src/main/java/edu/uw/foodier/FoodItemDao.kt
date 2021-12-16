package edu.uw.foodier
import androidx.room.*
// Created by Shruti Kompella

//interface for data access object
//defines methods to do operations on room database with food items
@Dao
interface FoodItemDao {

    // insert one food item into table
    @Insert
    fun insert(fooditem: FoodItem)

    // delete existing food item (passed in) from table
    @Delete
    fun delete(fooditem: FoodItem)

    // delete all food items from table
    @Query("delete from bookmarked_food_items")
    fun deleteAllFoods()

    //get all food items in table as a list
    @Query("select * from bookmarked_food_items")
    fun getAllFoodItems(): List<FoodItem>
}