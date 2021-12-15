package edu.uw.foodier

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import edu.uw.foodier.utils.subscribeOnBackground


@Database(entities = [FoodItem::class], version = 1)
abstract class FoodItemDatabase : RoomDatabase() {

    abstract fun foodItemDao(): FoodItemDao

    companion object {
        private var instance: FoodItemDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context): FoodItemDatabase {
            if(instance == null)
                instance = Room.databaseBuilder(ctx.applicationContext, FoodItemDatabase::class.java,
                    "note_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .allowMainThreadQueries()
                    .build()

            return instance!!

        }

        private val roomCallback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                populateDatabase(instance!!)
            }
        }

        private fun populateDatabase(db: FoodItemDatabase) {
            val noteDao = db.foodItemDao()
//            subscribeOnBackground {
//                noteDao.insert(FoodItem("title 1", "desc 1", 1))
//                noteDao.insert(FoodItem("title 2", "desc 2", 2))
//                noteDao.insert(FoodItem("title 3", "desc 3", 3))
//            }
        }
    }
}