package edu.uw.foodier

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import edu.uw.foodier.databinding.BookmarkActivityBinding

class BookmarkActivity : AppCompatActivity() {
    private lateinit var binding: BookmarkActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = BookmarkActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bookmarkText.setText("Hello second activity")

        binding.button2.setOnClickListener { view ->
            // goes to second activity
            val goToMainActivity = Intent(this, MainActivity::class.java)

            try {
                startActivity(goToMainActivity)
            } catch (e: ActivityNotFoundException) {
                Log.e("errorInMain", e.toString())
            }
        }
    }

}