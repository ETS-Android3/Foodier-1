// This file was created by Jade D'Souza for the Detail Page
// to call the Yelp API to find similar restaurants for the
// given food item, in Washington specifically.
// We used open source code by Yelp in order to navigate their API.
package edu.uw.foodier.model

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

// makes our get call to the API 
interface BusinessSearch {
    @GET("v3/businesses/search?location=WA")
    fun search(@Query("term") term: String): Single<BusinessSearchResponse>
}
