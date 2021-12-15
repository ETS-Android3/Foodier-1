package edu.uw.foodier.api
// This file is for the homePage created by Lauren Ng
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import edu.uw.foodier.models.distanceMaps.DistanceMap
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface GoogleMapsAPIService {
    @GET("directions/json")
    fun getDirections(
        @Query("key") apiKey: String?,
        @Query("origin") origin: String?,
        @Query("destination") destination: String?
    ): Call<DistanceMap>
}

private const val BASE_URL = "https://maps.googleapis.com/maps/api/"

private val retrofit = Retrofit.Builder() //Base URL is typically stored in a constants file or as a const string
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

object GoogleMapAPI {
    val retrofitService: GoogleMapsAPIService by lazy {
        retrofit.create(GoogleMapsAPIService::class.java)
    }
}