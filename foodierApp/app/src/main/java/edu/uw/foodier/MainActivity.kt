package edu.uw.foodier

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import edu.uw.foodier.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener { view ->
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