package edu.uw.foodier

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * ViewModel for SleepTrackerFragment.
 */
class FoodItemViewModelDB(
    val database: FoodItemDao,
    application: Application) : AndroidViewModel(application) {

    private val foods = database.getAllFoodItems()

//    val nightsString = Transformations.map(nights) { nights ->
//        formatNights(nights, application.resources)
//    }

//    private var tonight = MutableLiveData<FoodItem?>()

    init {
//        initializeTonight()
    }

//    private fun initializeTonight() {
//        viewModelScope.launch {
//            tonight.value = getFoodFromDatabase()
//        }
//    }
//
//    private suspend fun getFoodFromDatabase(): FoodItem? {
//        var night = database.getFoodItem()
//        if (night?.endTimeMilli != night?.startTimeMilli) {
//            night = null
//        }
//        return night
//    }

//    fun onStartTracking() {
//        viewModelScope.launch {
//            val newNight = SleepNight()
//            insert(newNight)
//            tonight.value = getTonightFromDatabase()
//        }
//    }

    private fun insert(foodItem: FoodItem) {
        database.insert(foodItem)
    }

//    fun onStopTracking() {
//        viewModelScope.launch {
//            val oldNight = tonight.value ?: return@launch
//            oldNight.endTimeMilli = System.currentTimeMillis()
//            update(oldNight)
//        }
//    }

    private suspend fun update(foodItem: FoodItem) {
        database.update(foodItem)
    }

    fun onClear() {
        viewModelScope.launch {
            clear()
        }
    }

    suspend fun clear() {
        database.deleteAllFoods()
    }
}