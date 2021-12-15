// This file was created by Jade D'Souza for the Detail Page
// to call the Yelp API to find similar restaurants for the
// given food item, in Washington specifically.
// We used open source code by Yelp in order to navigate their API.
package edu.uw.foodier.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val AUTH = "Bearer NQISPs8iEEYN3gqoDkU5lU8ooRG23nSF9134tzyulLhBY6rbEWw87wnI9yg8UdR6QbFLGV17gsmlSS_OiimJWlAVv1Yu1fRvGabZirAYJNFnA3Joh0vmuyEyRU0EW3Yx"

inline fun <reified T : Any> api(): T = YelpAPI.create(T::class.java)

object YelpAPI {
    private val client = OkHttpClient.Builder().addNetworkInterceptor {
        it.proceed(it.request().newBuilder().addHeader("Authorization", AUTH).build())
    }.build()

    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    fun <T> create(service: Class<T>): T {
        return Retrofit.Builder()
            .baseUrl("https://api.yelp.com/")
            .client(client)
            .addCallAdapterFactory(RxJava2SchedulerCallAdapterFactory(client))
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(service)
    }
}
