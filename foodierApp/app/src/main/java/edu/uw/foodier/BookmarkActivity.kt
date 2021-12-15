package edu.uw.foodier

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
//import edu.uw.foodier.databinding.BookmarkActivityBinding
import kotlinx.android.synthetic.main.bookmark_activity.*

class BookmarkActivity : AppCompatActivity() {
    //private lateinit var binding: BookmarkActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //binding = BookmarkActivityBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        setContentView(R.layout.bookmark_activity)

        val allElectionResults: MutableList<Int> = listOf(1,2,3,4,5,6,7).toMutableList()

        val bookmarkAdapter = BookmarkAdapter(allElectionResults)

        recycler_list.setHasFixedSize(true)
        recycler_list.adapter = bookmarkAdapter
        recycler_list.layoutManager = LinearLayoutManager(this)

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
}