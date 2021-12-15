// This file was created by Jade D'Souza for the Detail Page
// to call the Yelp API to find similar restaurants for the
// given food item, in Washington specifically.
// We used open source code by Yelp in order to navigate their API.
package edu.uw.foodier.model

import io.reactivex.Single
import edu.uw.foodier.api.Factory
import edu.uw.foodier.api.Provider
import edu.uw.foodier.api.api

open class BusinessRepo {
    companion object : Factory<BusinessRepo> by Provider({ BusinessRepo() })

    // searches the API for term passed in, returns
    // total number of businesses found, and a list of the businesses found
    open fun search(term: String): Single<BusinessSearchResponse> {
        return api<BusinessSearch>().search(term)
    }
}