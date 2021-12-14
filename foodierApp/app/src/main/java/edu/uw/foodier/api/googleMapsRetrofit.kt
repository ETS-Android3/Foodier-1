package edu.uw.foodier.api
// This file is for the homePage created by Lauren Ng
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class googleMapsRetrofit {
    private val service: GoogleMapsAPIService
    private val retrofit: Retrofit

    companion object {
        private const val URL = "https://maps.googleapis.com/maps/api/"
    }

    init {
        //This is builds your retrofit class, typically you do this only once as its expensive.
        retrofit =
            Retrofit.Builder() //Base URL is typically stored in a constants file or as a const string
                .baseUrl(URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        //This is the service you make network calls on.
        service = retrofit.create(GoogleMapsAPIService::class.java)
    }

    fun getService(): GoogleMapsAPIService {
        return service
    }

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
}