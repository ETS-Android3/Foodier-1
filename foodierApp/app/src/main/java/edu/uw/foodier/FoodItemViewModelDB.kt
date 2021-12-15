//package edu.uw.foodier
//
//import android.app.Application
//import androidx.lifecycle.AndroidViewModel
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.Transformations
//import androidx.lifecycle.viewModelScope
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.Job
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.withContext
//
///**
// * ViewModel for SleepTrackerFragment.
// */
//class SleepTrackerViewModel(
//    val database: FoodItemDao,
//    application: Application) : AndroidViewModel(application) {
//
//    private val nights = database.getAllFoodItems()
//
////    val nightsString = Transformations.map(nights) { nights ->
////        formatNights(nights, application.resources)
////    }
//
//    private var tonight = MutableLiveData<FoodItem?>()
//
//    init {
//        initializeTonight()
//    }
//
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
//
//    fun onStartTracking() {
//        viewModelScope.launch {
//            val newNight = SleepNight()
//            insert(newNight)
//            tonight.value = getTonightFromDatabase()
//        }
//    }
//
//    private suspend fun insert(night: SleepNight) {
//        database.insert(night)
//    }
//
//    fun onStopTracking() {
//        viewModelScope.launch {
//            val oldNight = tonight.value ?: return@launch
//            oldNight.endTimeMilli = System.currentTimeMillis()
//            update(oldNight)
//        }
//    }
//
//    private suspend fun update(night: SleepNight) {
//        database.update(night)
//    }
//
//    fun onClear() {
//        viewModelScope.launch {
//            clear()
//            tonight.value = null
//        }
//    }
//
//    suspend fun clear() {
//        database.clear()
//    }
//}