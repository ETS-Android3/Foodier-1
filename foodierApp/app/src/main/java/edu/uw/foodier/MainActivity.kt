package edu.uw.foodier
// This file is for the mainActivity all created by Lauren Ng
// and is where the app is initialized and getting the current
// location of the user while also asking for permissions to get
// their current location
import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.app.ActivityCompat.requestPermissions
import android.widget.Toast
import com.google.android.gms.tasks.Task
import androidx.annotation.NonNull
import com.google.android.gms.tasks.OnCompleteListener
import androidx.core.location.LocationManagerCompat.isLocationEnabled
import android.annotation.SuppressLint
import android.content.Context
import androidx.core.location.LocationManagerCompat
import android.content.pm.PackageManager
import android.location.LocationManager
import androidx.core.app.ActivityCompat
import android.os.Looper
import android.provider.Settings
import androidx.activity.viewModels
import com.google.android.gms.location.*
import edu.uw.foodier.viewmodels.homePageViewModel

class MainActivity : AppCompatActivity() {
    var mFusedLocationClient: FusedLocationProviderClient? = null
    private val model : homePageViewModel by viewModels()
    private lateinit var dao: FoodItemDao

    // on create sets the content view as activity main and also
    // creates functionality for our floating action button to be
    // clickable to go to the bookmark activity.
    // also, we are setting up the app to get the current location of the user
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dao = FoodItemDatabase.getInstance(this).foodItemDao()

        button.setOnClickListener { view ->
            val goToBookmarkActivity = Intent(this, BookmarkActivity::class.java)
            try {
                startActivity(goToBookmarkActivity)
            } catch (e: ActivityNotFoundException) {
                Log.e("MainActivity", e.toString())
            }
        }

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        // method to get the locatiom
        getLastLocation()
    }

    // getting the latest location of the user and updating the model of we're able to get it
    @SuppressLint("MissingPermission")
    fun getLastLocation() {
        if (checkPermissions()) {
            // check if location is enabled
            if (isLocationEnabled()) {
                if (mFusedLocationClient != null) {
                    mFusedLocationClient!!.lastLocation.addOnCompleteListener { task ->
                        val location = task.result
                        if (location == null) {
                            requestNewLocationData()
                        } else {
                            model.updateLocation(location)
                        }
                    }
                } else {
                    Log.e("Mainactivty", "FusedLocation is null")
                }

            } else {
                Toast.makeText(this, "Please turn on" + " your location...", Toast.LENGTH_LONG)
                    .show()
                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivity(intent)
            }
        } else {
            // if permissions aren't available, request for permissions
            requestPermissions()
        }
    }

    // asking for new location data and suppressing the missing permission data once the user
    // has allowed it once.
    @SuppressLint("MissingPermission")
    private fun requestNewLocationData() {

        // Initializing LocationRequest
        // object with appropriate methods
        val mLocationRequest = LocationRequest()
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
        mLocationRequest.setInterval(5)
        mLocationRequest.setFastestInterval(0)
        mLocationRequest.setNumUpdates(1)

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        mFusedLocationClient?.requestLocationUpdates(mLocationRequest, mLocationCallback, Looper.myLooper())
    }

    // method to update location once we get the location result
    private val mLocationCallback: LocationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            val mLastLocation = locationResult.lastLocation
            model.updateLocation(mLastLocation)
        }
    }

    // method to check for permissions
    private fun checkPermissions(): Boolean {
        return ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    // method to request for permissions
    private fun requestPermissions() {
        requestPermissions(
            this, arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            ), 44
        )
    }

    // method to check if location is enabled
    private fun isLocationEnabled(): Boolean {
        val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
            LocationManager.NETWORK_PROVIDER
        )
    }

    // If everything is alright then we execute this function to get the latest location
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 44) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLastLocation()
            }
        }
    }

    // when the app resumes, check permission and get latest location
    override fun onResume() {
        super.onResume()
        if (checkPermissions()) {
            getLastLocation()
        }
    }

}