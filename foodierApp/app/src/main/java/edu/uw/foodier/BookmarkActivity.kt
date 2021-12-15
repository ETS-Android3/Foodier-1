package edu.uw.foodier

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
//import edu.uw.foodier.databinding.BookmarkActivityBinding
import kotlinx.android.synthetic.main.bookmark_activity.*
import kotlinx.coroutines.launch
import android.os.AsyncTask
import android.provider.ContactsContract
import java.lang.ref.WeakReference


class BookmarkActivity : AppCompatActivity() {
    //private lateinit var binding: BookmarkActivityBinding
    private lateinit var dao: FoodItemDao
    private lateinit var foods: List<FoodItem>
    private lateinit var bookmarkAdapter: BookmarkAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //binding = BookmarkActivityBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        setContentView(R.layout.bookmark_activity)
        displayList()

//        val allElectionResults: MutableList<Int> = listOf<Int>(1,2,3,4,5).toMutableList()
//
//        bookmarkAdapter = BookmarkAdapter(allElectionResults)

//        recycler_list.setHasFixedSize(true)
//        recycler_list.adapter = bookmarkAdapter
//        recycler_list.layoutManager = LinearLayoutManager(this)

        bookmarkText.setText("Bookmarked Restaurants")

        bookmarkToHomeBtn.setOnClickListener { view ->
            // goes to second activity
            val goToMainActivity = Intent(this, MainActivity::class.java)

            try {
                startActivity(goToMainActivity)
            } catch (e: ActivityNotFoundException) {
                Log.e("errorInMain", e.toString())
            }
        }

        bookmarkAdapter.itemClickListener = { foodDetails ->
            Toast.makeText(this, "more info about food $foodDetails", Toast.LENGTH_LONG)
                .show()
        }
    }

    private fun displayList() {
        // initialize database instance
        //noteDatabase = NoteDatabase.getInstance(this@NoteListActivity)
        // fetch list of notes in background thread
        dao = FoodItemDatabase.getInstance(this).foodItemDao()
        RetrieveTask(this).execute()
    }

//    private fun getFoods(): List<FoodItem> {
//        var foodList: List<FoodItem> = dao.getAllFoodItems()
////        lifecycleScope.launch {
////            foodList = dao.getAllFoodItems()
////        }
//        return foodList
//    }

    private class RetrieveTask internal constructor(context: BookmarkActivity?) :
        AsyncTask<Void?, Void?, List<FoodItem>?>() {
        private val activityReference: WeakReference<BookmarkActivity>

        override fun doInBackground(vararg p0: Void?): List<FoodItem>?  {
            return if (activityReference.get() != null) activityReference.get()?.dao?.getAllFoodItems() else null
        }

        override fun onPostExecute(foods: List<FoodItem>?) {
            if (foods != null && foods.size > 0) {
                activityReference.get()?.foods = foods

                // hides empty text view
                //activityReference.get().textViewMsg.setVisibility(View.GONE)

                // create and set the adapter on RecyclerView instance to display list
                activityReference.get()?.bookmarkAdapter = BookmarkAdapter(foods.toMutableList())
                activityReference.get()?.recycler_list?.adapter = activityReference.get()?.bookmarkAdapter
            }
        }

        // only retain a weak reference to the activity
        init {
            activityReference = WeakReference(context)
        }
    }

}