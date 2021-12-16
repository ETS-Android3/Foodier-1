package edu.uw.foodier
// Created by Shruti Kompella
// Help from Jade D'Souza to allow non-asynchronous calls
// that would not lock UI.
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Database class for Food item (only contains one table defined in FoodItem.kt)
@Database(entities = [FoodItem::class], version = 1)
abstract class FoodItemDatabase : RoomDatabase() {

    abstract fun foodItemDao(): FoodItemDao

    companion object {
        private var instance: FoodItemDatabase? = null

        //returns instance of room database that we can access from other activities/fragments
        @Synchronized
        fun getInstance(ctx: Context): FoodItemDatabase {
            if(instance == null)
                instance = Room.databaseBuilder(ctx.applicationContext, FoodItemDatabase::class.java,
                    "foodItem_database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()

            return instance!!

        }
    }
}