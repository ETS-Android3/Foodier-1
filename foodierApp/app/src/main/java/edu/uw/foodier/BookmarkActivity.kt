package edu.uw.foodier
// Created by Shruti Kompella to set up recycler view to
// show all foods that have been bookmarked as a list,
// toaster, Jade D'Souza helped with fixing database issues
// caused by asynchronous calls that affected BookmarkAdapter.

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.bookmark_activity.*

// Activity to show all foods that have been bookmarked as a list
class BookmarkActivity : AppCompatActivity() {
    private lateinit var dao: FoodItemDao
    private lateinit var foods: List<FoodItem>
    private lateinit var bookmarkAdapter: BookmarkAdapter

    // creates the view for bookmark page when it is first navigated to
    // sets the text at top, and retrieves food item from room database that have been bookmarked
    // and displays them in recyclerview
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bookmark_activity)

        bookmarkText.text = "Bookmarked Restaurants"

        bookmarkToHomeBtn.setOnClickListener {
            // goes to second activity
            val goToMainActivity = Intent(this, MainActivity::class.java)

            try {
                startActivity(goToMainActivity)
            } catch (e: ActivityNotFoundException) {
                Log.e("errorInMain", e.toString())
            }
        }

        dao = FoodItemDatabase.getInstance(this).foodItemDao()
        foods =  dao.getAllFoodItems()

        bookmarkAdapter = BookmarkAdapter(foods as MutableList<FoodItem>)
        bookmarkAdapter.itemClickListener = { foodDetails ->
            Toast.makeText(this, "more info about food $foodDetails", Toast.LENGTH_LONG)
                .show()
        }
        recycler_list.setHasFixedSize(true)
        recycler_list.adapter = bookmarkAdapter
        recycler_list.layoutManager = LinearLayoutManager(this)
    }
}