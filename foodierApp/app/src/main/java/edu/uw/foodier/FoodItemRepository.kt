package edu.uw.foodier

import android.app.Application
import androidx.lifecycle.LiveData
import edu.uw.foodier.utils.subscribeOnBackground

class FoodItemRepository(application: Application) {

    private var foodItemDao: FoodItemDao
    private var allFoodItems: List<FoodItem>

    private val database = FoodItemDatabase.getInstance(application)

    init {
        foodItemDao = database.foodItemDao()
        allFoodItems = foodItemDao.getAllFoodItems()
    }

    fun insert(foodItem: FoodItem) {
        subscribeOnBackground {
            foodItemDao.insert(foodItem)
        }
    }

    fun update(foodItem: FoodItem) {
        subscribeOnBackground {
            foodItemDao.update(foodItem)
        }
    }

    fun delete(foodItem: FoodItem) {
        subscribeOnBackground {
            foodItemDao.delete(foodItem)
        }
    }

    fun deleteAllNotes() {
        subscribeOnBackground {
            foodItemDao.deleteAllFoods()
        }
    }

    fun getAllFoodItems(): List<FoodItem> {
        return allFoodItems
    }
}