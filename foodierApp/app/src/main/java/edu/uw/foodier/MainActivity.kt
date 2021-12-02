package edu.uw.foodier

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view ->
            // goes to second activity
            val goToSecondActivity = Intent(this, BookmarkActivity::class.java)

            try {
                startActivity(goToSecondActivity)
            } catch (e: ActivityNotFoundException) {
                Log.e("errorInMain", e.toString())
            }
        }

    }
}