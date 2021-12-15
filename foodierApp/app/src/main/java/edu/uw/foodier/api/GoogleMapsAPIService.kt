package edu.uw.foodier.api
// This file is for the homePage created by Lauren Ng
// and is meant to get the API service from googleMaps
// currently, the only request being called is for directions based off origin and destination

import edu.uw.foodier.models.distanceMaps.DistanceMap
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// setting up the interface that describes the function and api url that is used in the mainPage
interface GoogleMapsAPIService {
    @GET("maps/api/directions/json")
    fun getDirections(
        @Query("key") apiKey: String?,
        @Query("origin") origin: String?,
        @Query("destination") destination: String?
    ): Call<DistanceMap>
}

// URL of the api
private const val BASE_URL = "https://maps.googleapis.com/"

// creating the retrofit handler to run the API
private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

// creating the API object that'll be called throughout the app to use the API service
object GoogleMapAPI {
    val retrofitService: GoogleMapsAPIService by lazy {
        retrofit.create(GoogleMapsAPIService::class.java)
    }
}