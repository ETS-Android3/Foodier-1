package edu.uw.foodier
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FoodItemDao {

    @Insert
    fun insert(fooditem: FoodItem)

    @Update
    fun update(fooditem: FoodItem)

    @Delete
    fun delete(fooditem: FoodItem)

    @Query("delete from bookmarked_food_items")
    fun deleteAllFoods()

    @Query("select * from bookmarked_food_items")
    fun getAllFoodItems(): List<FoodItem>
}